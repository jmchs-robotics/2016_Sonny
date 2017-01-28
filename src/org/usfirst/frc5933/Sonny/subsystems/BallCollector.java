// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5933.Sonny.subsystems;

import org.usfirst.frc5933.Sonny.RobotMap;
import org.usfirst.frc5933.Sonny.commands.*;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class BallCollector extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final CANTalon elevatorMotor = RobotMap.ballCollectorElevatorMotor;
    private final CANTalon vacuumMotor = RobotMap.ballCollectorVacuumMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Add a switch subsystem
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	//Start at max RPM
    	//Slow motor slightly, -%5 percent each interval
    	//when pressure pad detected (Add a switch subsystem) stop motor.
    	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

