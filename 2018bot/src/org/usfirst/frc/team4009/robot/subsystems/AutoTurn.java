package org.usfirst.frc.team4009.robot.subsystems;


import org.usfirst.frc.team4009.robot.Robot;
import org.usfirst.frc.team4009.robot.Turnrate;
import org.usfirst.frc.team4009.robot.commands.DriveCommand;
import org.usfirst.frc.team4009.robot.subsystems.RotationOutput;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDSource;

/**e
 *
 */

public class AutoTurn extends Subsystem  {
	public AHRS ahrs;
	public PIDSource pidsource1;
	public static final double kToleranceDegrees = 4.0f;
	public double rotationRate;
	public double rotationCount;
	public double turnNegativeNinety;
	public static double kP, kI, kD;
	public PIDController autoTurn;
	public Timer twistTimer;
	public double rotateToAngleRate;
	public PIDController turnController;
	public RotationOutput rotationOutput;
	public Turnrate turnrate;
    // Initialize your subsystem here
    public AutoTurn() {
    	try {
			ahrs = new AHRS(I2C.Port.kMXP);
		} catch (RuntimeException ex) {
			DriverStation.reportError("Error instantating navX-MXP: " + ex.getMessage(), true);
		}
    	
		kP = 0.025;
		kI = 0.002;
		kD = 0.002;
		
		rotationOutput = new RotationOutput();
		turnrate = new Turnrate();
		
		autoTurn = new PIDController(kP, kI, kD, ahrs, (PIDOutput) turnrate);
		autoTurn.setInputRange(-180.0f, 180.0f);
		autoTurn.setOutputRange(-1, 1);
		autoTurn.setAbsoluteTolerance(kToleranceDegrees);
		autoTurn.setContinuous(true);
		ahrs.enableLogging(true);
		twistTimer = new Timer();
    }
	protected void initDefaultCommand() {
		setDefaultCommand (new DriveCommand());
		
	}

 
    
    public void setSetPoint(double heading) {
	autoTurn.setSetpoint(heading);
	 
}
	protected double returnPIDInput() {

		return ahrs.getYaw();
	}
    
    
}
