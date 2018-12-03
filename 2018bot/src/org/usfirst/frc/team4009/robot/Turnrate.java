package org.usfirst.frc.team4009.robot;

import org.usfirst.frc.team4009.robot.subsystems.AutoTurn;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

public class Turnrate implements PIDOutput {
	public double rate;
	PIDController TurnContoller;
    public Turnrate turnrate;
	@Override
	public void pidWrite(double output) {
//		if (Math.abs(Robot.autoturn.ahrs.getYaw() - Robot.autoturn.heading) <= 4) {
			
		
//		rate = 0;
//		}
//		else {
			rate = output;
		}
		// TODO Auto-generated method stub
		
	}


