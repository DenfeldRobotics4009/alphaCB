package org.usfirst.frc.team4009.robot.subsystems;

import org.usfirst.frc.team4009.robot.commands.LiftCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
	
	
	public WPI_TalonSRX lowerLift;
	public Encoder lowerEncoder;
	public DigitalInput limitswitchdown;
	
	private boolean overridden;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Lift() {
		
		lowerLift = new WPI_TalonSRX(6);
		limitswitchdown = new DigitalInput(6);
		lowerEncoder = new Encoder(5, 4, false, Encoder.EncodingType.k4X);
		lowerEncoder.setMaxPeriod(.1);
		lowerEncoder.setMinRate(10);
		lowerEncoder.setDistancePerPulse(7);
		lowerEncoder.setReverseDirection(false);
		lowerEncoder.setSamplesToAverage(7);
	
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new LiftCommand());
    }
    public void setlowerLift(double liftspeedup) {
    	lowerLift.set(liftspeedup);
    }
    
   
    public void setOverridden(boolean stop) {
    	stop = overridden;
    }
    
    public boolean isOverriden() {
    	return overridden;
    }
    }
