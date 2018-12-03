package org.usfirst.frc.team4009.robot.subsystems;


import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RotationOutput extends Subsystem implements PIDOutput {
	public PIDController turnController;
	public double rate;
	public RotationOutput rotationOutput;

	@Override
	public void pidWrite(double output) {
		output = rate;
		
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	

}
