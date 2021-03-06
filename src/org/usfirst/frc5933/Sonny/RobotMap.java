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
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

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
    public static SpeedController climbingServoClimbingMotor;
    public static SpeedController backFlapperBackMotor;
    public static CANTalon climbingSpindleClimbSpindle;
    public static CANTalon ballCollectorElevatorMotor;
    public static CANTalon ballCollectorVacuumMotor;
    public static CANTalon flyWheelFlyWheelMotor;
    public static SpeedController frontFlapperFrontMotor;
    public static CANTalon hopperAgitatorAgitiatorMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeft = new CANTalon(11);
        LiveWindow.addActuator("DriveTrain", "Left", driveTrainLeft);
        
        driveTrainRight = new CANTalon(12);
        LiveWindow.addActuator("DriveTrain", "Right", driveTrainRight);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeft, driveTrainRight);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        climbingServoClimbingMotor = new Spark(0);
        LiveWindow.addActuator("ClimbingServo", "ClimbingMotor", (Spark) climbingServoClimbingMotor);
        
        backFlapperBackMotor = new Spark(1);
        LiveWindow.addActuator("BackFlapper", "BackMotor", (Spark) backFlapperBackMotor);
        
        climbingSpindleClimbSpindle = new CANTalon(0);
        LiveWindow.addActuator("ClimbingSpindle", "ClimbSpindle", climbingSpindleClimbSpindle);
        
        ballCollectorElevatorMotor = new CANTalon(3);
        LiveWindow.addActuator("BallCollector", "ElevatorMotor", ballCollectorElevatorMotor);
        
        ballCollectorVacuumMotor = new CANTalon(4);
        LiveWindow.addActuator("BallCollector", "VacuumMotor", ballCollectorVacuumMotor);
        
        flyWheelFlyWheelMotor = new CANTalon(20);
        LiveWindow.addActuator("FlyWheel", "FlyWheelMotor", flyWheelFlyWheelMotor);
        
        frontFlapperFrontMotor = new Spark(2);
        LiveWindow.addActuator("FrontFlapper", "FrontMotor", (Spark) frontFlapperFrontMotor);
        
        hopperAgitatorAgitiatorMotor = new CANTalon(6);
        LiveWindow.addActuator("HopperAgitator", "AgitiatorMotor", hopperAgitatorAgitiatorMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
