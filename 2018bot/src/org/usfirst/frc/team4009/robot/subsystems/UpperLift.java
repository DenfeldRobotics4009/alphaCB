package org.usfirst.frc.team4009.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class UpperLift extends Subsystem {
	public WPI_TalonSRX upperLift;
	public UpperLift() {
		
		upperLift = new WPI_TalonSRX(5);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setupperLift(double upperspeed) {
    	upperLift.set(upperspeed);
    }
}

