package org.usfirst.frc.team4009.robot.subsystems;

import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.commands.CameraC;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {

	public NetworkTable limelight;
	
	public Camera() {
		limelight = NetworkTableInstance.getDefault().getTable("limelight");
	}

	
	
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new CameraC()); 
    	}
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    public void SetDefaultDouble(final double camset) {
    	limelight.getEntry("camMode").setDefaultDouble(1);
		limelight.getEntry("ledMode").setDefaultDouble(1);
    }
    
    public void SetDouble(final double camset) {
    	Robot.camera.limelight.getEntry("camMode").setDouble(1);
		Robot.camera.limelight.getEntry("ledMode").setDouble(1);
    }
		
		
	
}

