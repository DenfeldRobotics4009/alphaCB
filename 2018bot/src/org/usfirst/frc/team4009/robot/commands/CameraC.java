package org.usfirst.frc.team4009.robot.commands;

import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.subsystems.Camera;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraC extends Command {
	
  public final double camset = 1;
    
  public CameraC() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.camera.limelight.getEntry("camMode").setDefaultDouble(camset);
		Robot.camera.limelight.getEntry("ledMode").setDefaultDouble(camset);
		Robot.camera.limelight.getEntry("camMode").setDouble(camset);
		Robot.camera.limelight.getEntry("ledMode").setDouble(camset);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
