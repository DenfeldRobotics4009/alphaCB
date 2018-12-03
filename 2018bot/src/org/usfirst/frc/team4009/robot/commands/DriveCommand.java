package org.usfirst.frc.team4009.robot.commands;

import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.subsystems.RotationOutput;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCommand extends Command {

    public DriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	requires(Robot.autoturn);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.autoturn.twistTimer.start();
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double forward;
		double twist;
		Robot.autoturn.autoTurn.enable();
		//DRIVE CODE HERE
		boolean pTrig = Robot.m_oi.joystick1.getTrigger();// this will be fixed in OI- name the trigger something so we don't have to type this thing out
		  														//Like what?
																	//trigger2 (for trigger on joystick 2)
		  	double pMag = (Robot.m_oi.joystick1.getThrottle() +1) /2;
			double pMax = 0.75;
			double pMin = 0.25;
			final double DZ = 0.1;
			final double twistDZ = 0.55;
			double pScale;
			double heading;
			//DZ
		if (pTrig) {
				pScale = 1;
		} else {
				pScale = (pMag * (pMax - pMin) + pMin);
			}
			if(Math.abs(Robot.m_oi.joystick1.getY())< DZ){
				forward = 0;
			}
			else {
			
				forward = Math.signum(Robot.m_oi.joystick1.getY()) * pScale *((Math.abs(Robot.m_oi.joystick1.getY()) - DZ) *(1/(1 - DZ)))*-1;
			}
			//twist DZ
			if (Math.abs(Robot.m_oi.joystick1.getZ()) < twistDZ) {
			if (Robot.autoturn.twistTimer.get() < 0.33) {
				twist = 0;
				heading = Robot.autoturn.ahrs.getYaw();
				Robot.autoturn.autoTurn.setSetpoint(heading);
				
			}
			else { twist = Robot.autoturn.turnrate.rate;
			}
			}else {
				twist = Math.signum(Robot.m_oi.joystick1.getZ()) * pScale * ((Math.abs(Robot.m_oi.joystick1.getZ()) - twistDZ) * (1/(1 - twistDZ)));
				Robot.autoturn.twistTimer.reset();
				heading = Robot.autoturn.ahrs.getYaw();
				Robot.autoturn.autoTurn.setSetpoint(heading);
		}
		Robot.drivetrain.arcadeDrive(forward, twist);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns trues
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
