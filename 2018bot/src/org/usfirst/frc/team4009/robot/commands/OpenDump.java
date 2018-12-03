package org.usfirst.frc.team4009.robot.commands;

import org.usfirst.frc.team4009.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenDump extends Command {

    public OpenDump() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.dumper);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double DHL = 98;
    	
    	while (Robot.dumper.dumperEncoder.get() < DHL && Robot.dumper.limitSwitchDumperOpen.get() == false) { 
    		if (Robot.dumper.dumperEncoder.get() < 33) {
    			Robot.dumper.dumperMotor.set(-1);
    		}
    		if (Robot.dumper.dumperEncoder.get() > 33 && Robot.dumper.dumperEncoder.get() < 70) {
    			Robot.dumper.dumperMotor.set(-0.65);
    		}
    		if(Robot.dumper.dumperEncoder.get() >= 70) {
    			Robot.dumper.dumperMotor.set(-0.55);
    		}
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
