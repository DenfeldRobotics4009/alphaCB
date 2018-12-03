package org.usfirst.frc.team4009.robot.commands;

import org.usfirst.frc.team4009.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftCommand extends Command {

    public LiftCommand() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		double liftspeedup;
		double liftDZ = 0.25;
		double LHL = 13300;
		double LLL = 50;
		if (Math.abs(Robot.m_oi.joystick2.getY()) <= liftDZ){
			liftspeedup = 0;
		}
		else {
		 if (Robot.lift.lowerEncoder.get() > LHL && Robot.m_oi.joystick2.getY() > 0 && Robot.m_oi.joystick2.getRawButton(7) == false || Robot.lift.lowerEncoder.get() < LLL && Robot.m_oi.joystick2.getY() < 0 && Robot.m_oi.joystick2.getRawButton(7) == false || !Robot.lift.limitswitchdown.get() && Robot.m_oi.joystick2.getRawButton(7) == false) {
		 liftspeedup = 0;
		 }
		 
		else {
		 liftspeedup = Math.signum(Robot.m_oi.joystick2.getY()) * ((Math.abs(Robot.m_oi.joystick2.getY()) - liftDZ) * (1/(1 - liftDZ)));
			}
		 }
	
	

		Robot.lift.lowerLift.set(liftspeedup);
    
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
