package org.usfirst.frc5933.Sonny;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Helmsman {

    public static final String NADA = "nada";
    public static final String RIGHT = "right";
    public static final String LEFT = "left";
    
    private String ip_;
    private int port_;
    private boolean is_connected_ = false;
    private byte[] data_ = new byte[1024];
    private DatagramSocket socket_;
    private InetAddress addr_;
    private String direction_ = new String();
    private double degrees_ = 0;
    
    public Helmsman(String ip, int port) {
        ip_ = ip;
        port_ = port;
    }
    
    public boolean connect() {
        try {
            socket_ = new DatagramSocket();
            socket_.setSoTimeout(5);
            addr_ = InetAddress.getByName(ip_);
        } catch (UnknownHostException ex) {
            return false;
        } catch (SocketException ex) {
            return false;
        }
        return true;
    }
    
    public boolean is_connected() {
        return is_connected_;
    }
    
    public boolean recv() {
        DatagramPacket packet = new DatagramPacket(data_, data_.length, addr_, port_);
        try {
            socket_.receive(packet);
            if (packet.getData().length > 0) {
                // TODO: Parse the data and set the direction and degrees
                direction_ = NADA;
                degrees_ = 0;
                return true;
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
    
    public String get_direction() {
        String tmp = direction_;
        direction_ = NADA;
        return tmp;
    }
    
    public double get_degrees() {
        double tmp = degrees_;
        degrees_ = 0;
        return tmp;
    }
}
