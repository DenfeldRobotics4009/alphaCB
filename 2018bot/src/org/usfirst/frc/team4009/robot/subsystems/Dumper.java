package org.usfirst.frc.team4009.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Dumper extends Subsystem {
	public WPI_TalonSRX dumperMotor;
	public DigitalInput limitSwitchDumperOpen, limitSwitchDumperClosed;
	public Encoder dumperEncoder;
	public Dumper() {
		dumperMotor = new WPI_TalonSRX(4);
		limitSwitchDumperOpen = new DigitalInput(7);
		limitSwitchDumperClosed = new DigitalInput(0);
		dumperEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    } 
    
}

