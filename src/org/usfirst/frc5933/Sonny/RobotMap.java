// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Sonny;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.*;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainLeft;
    public static CANTalon driveTrainRight;
    public static RobotDrive driveTrainRobotDrive;
    public static CANTalon climbingSpindlespindleMotor;
    public static Servo climbingServoclawServo;
    public static CANTalon vacuumMotor;
    public static CANTalon elevatorMotor;
    public static Jaguar frontFlapperFrontFlapMotor;
    public static Jaguar backFlapperBackFlapMotor;
    public static CANTalon hopperAgitatorFeederMotor;
    public static CANTalon flyWheelShooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeft = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "Left", driveTrainLeft);
        
        driveTrainRight = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "Right", driveTrainRight);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeft, driveTrainRight);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        climbingSpindlespindleMotor = new CANTalon(0);
        LiveWindow.addActuator("Climbing Spindle", "spindleMotor", climbingSpindlespindleMotor);
        
        climbingServoclawServo = new Servo(0);
        LiveWindow.addActuator("Climbing Servo", "clawServo", climbingServoclawServo);
        
        vacuumMotor = new CANTalon(3);
        LiveWindow.addActuator("Vacuum Motor", "Beater Bar", vacuumMotor);
        
        elevatorMotor = new CANTalon(4);
        LiveWindow.addActuator("Elevator", "Elevator", elevatorMotor);
        
        frontFlapperFrontFlapMotor = new Jaguar(0);
        LiveWindow.addActuator("Front Flapper", "Front Flap Motor", frontFlapperFrontFlapMotor);
        
        backFlapperBackFlapMotor = new Jaguar(1);
        LiveWindow.addActuator("Back Flapper", "Back Flap Motor", backFlapperBackFlapMotor);
        
        hopperAgitatorFeederMotor = new CANTalon(7);
        LiveWindow.addActuator("Hopper Agitator", "Feeder Motor", hopperAgitatorFeederMotor);
        
        flyWheelShooter = new CANTalon(8);
        LiveWindow.addActuator("FlyWheel", "Shooter", flyWheelShooter);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
