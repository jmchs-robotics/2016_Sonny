
package org.usfirst.frc5933.Sonny;

import java.util.TimerTask;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class Lidar {
    
    private DigitalInput input;
    private DigitalOutput output;    
    private Counter counter;
    
    public Lidar() {
        input = new DigitalInput(9);
        counter = new Counter(input);
        counter.setSemiPeriodMode(true);
        System.out.println("SAMPLE: " + counter.getSamplesToAverage());
        counter.setSamplesToAverage(10);
        output = new DigitalOutput(8);
        output.set(true);
    }

    public void trigger() {
        counter.reset();
        output.set(false);
        System.out.println("TRIGGER");
    }
    
    public void getDistance() {
        double raw = counter.getPeriod() * 10000;
        // double distance1 = ((0.05 * raw * raw) + (2.6 * raw)) + 0;
        
        double distance2  = (raw * 2.75);
        
        // System.out.println("DISTANCE1: " + distance1);
        System.out.println("DISTANCE2: " + distance2);
        System.out.println("RAW: " + raw);
        output.set(true);
    }
}

