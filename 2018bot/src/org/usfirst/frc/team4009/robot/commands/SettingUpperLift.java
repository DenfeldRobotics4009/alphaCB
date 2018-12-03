package org.usfirst.frc.team4009.robot.commands;

import org.usfirst.frc.team4009.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SettingUpperLift extends Command {

    public SettingUpperLift() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.upperlift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double upperspeed;
    	upperspeed = Robot.m_oi.joystick2.getThrottle();
    	Robot.upperlift.upperLift.set(upperspeed);
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
