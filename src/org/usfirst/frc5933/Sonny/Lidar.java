
package org.usfirst.frc5933.Sonny;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Timer;

public class Lidar {

    private I2C i2c;
    private static byte[] distance;
    private java.util.Timer updater;
    
    private final int LIDAR_ADDR = 0x62;
    private final int LIDAR_CONFIG_REGISTER = 0x00;
    private final int LIDAR_DISTANCE_REGISTER = 0x8f;
    
    private static boolean hasRead = false;

    public Lidar() {
        i2c = new I2C(I2C.Port.kMXP, LIDAR_ADDR);
        distance = new byte[2];
        updater = new java.util.Timer();
    }

    // Distance in cm
    public static int getDistance() {
        if (!hasRead)
            return 0;
        return (int) Integer.toUnsignedLong(distance[0] << 8) + Byte.toUnsignedInt(distance[1]);
    }

    public double pidGet() {
        return getDistance();
    }

    // Start 10Hz polling
    public void start() {
        updater.scheduleAtFixedRate(new LIDARUpdater(), 0, 1000);
    }

    // Start polling for period in milliseconds
    public void start(int period) {
        updater.scheduleAtFixedRate(new LIDARUpdater(), 0, period);
    }

    public void stop() {
        updater.cancel();
    }

    // Update distance variable
    public void update() {
        distance[0] = 0;
        distance[1] = 0;
        hasRead = false;
        
        if (i2c.write(LIDAR_CONFIG_REGISTER, 0x04)) {
            System.err.println("NO WRITE");
            return;
        }
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if (i2c.read(LIDAR_DISTANCE_REGISTER, 2, distance)) {
            System.err.println("NO READ");
            return;
        }
        hasRead = true;
    }

    // Timer task to keep distance updated
    private class LIDARUpdater extends TimerTask {
        public void run() {
            update();
            System.out.println("DISTANCE: " + getDistance());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

