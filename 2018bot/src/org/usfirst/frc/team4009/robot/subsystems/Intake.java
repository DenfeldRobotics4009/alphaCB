package org.usfirst.frc.team4009.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	WPI_TalonSRX left1, right1, left2, right2;
	public SpeedControllerGroup leftgroup, rightgroup;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
public Intake() {
	left1 = new WPI_TalonSRX(7);
	right1 = new WPI_TalonSRX(8);
	left2 = new WPI_TalonSRX(10);
	right2 = new WPI_TalonSRX(9);
	
	leftgroup = new SpeedControllerGroup(left1, left2);
	rightgroup = new SpeedControllerGroup(right1, right2);
}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}

