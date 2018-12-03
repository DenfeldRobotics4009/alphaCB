package org.usfirst.frc.team4009.robot.subsystems;

import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.commands.DriveCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem {
	public WPI_TalonSRX can1, can2, can3, can4;
	
	public SpeedControllerGroup group1, group2;
	
	public DifferentialDrive drive1;
	

	private boolean overridden;
	
	public DriveTrain() {
		can1 = new WPI_TalonSRX(2);
		can2 = new WPI_TalonSRX(0);
		can3 = new WPI_TalonSRX(3);
		can4 = new WPI_TalonSRX(1);
		
		group1 = new SpeedControllerGroup (can1, can2);
		group2 = new SpeedControllerGroup (can3, can4);
		
		drive1 = new DifferentialDrive(group1, group2);
	}
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
    public void arcadeDrive(double forward, double twist) {
    	drive1.arcadeDrive(forward, twist);
    	
    }

	public void setOverridden(boolean on) {
		on = overridden;
		
	}
    public boolean isOverridden() {
    	return overridden;
    }
}

