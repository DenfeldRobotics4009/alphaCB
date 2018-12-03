/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4009.robot;

import org.usfirst.frc.team4009.robot.commands.DumpAction;
import org.usfirst.frc.team4009.robot.commands.PullIn;
import org.usfirst.frc.team4009.robot.commands.PushOut;
import org.usfirst.frc.team4009.robot.commands.SettingUpperLift;
import org.usfirst.frc.team4009.robot.commands.StopUpperLift;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick joystick1, joystick2;

	
	public OI() {
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		
		
		Button but1a = new JoystickButton(joystick1, 1);
		Button but2a = new JoystickButton(joystick1, 2);
		Button but3a = new JoystickButton(joystick1, 3);
		Button but4a = new JoystickButton(joystick1, 4);
		Button but5a = new JoystickButton(joystick1, 5);
		Button but6a = new JoystickButton(joystick1, 6);
		Button but7a = new JoystickButton(joystick1, 7);
		Button but8a = new JoystickButton(joystick1, 8);
		Button but9a = new JoystickButton(joystick1, 9);
		Button but10a = new JoystickButton(joystick1, 10);
		Button but11a = new JoystickButton(joystick1, 11);
		Button but12a = new JoystickButton(joystick1, 12);
		
		Button but1b = new JoystickButton(joystick2, 1);
		Button but2b = new JoystickButton(joystick2, 2);
		Button but3b = new JoystickButton(joystick2, 3);
		Button but4b = new JoystickButton(joystick2, 4);
		Button but5b = new JoystickButton(joystick2, 5);
		Button but6b = new JoystickButton(joystick2, 6);
		Button but7b = new JoystickButton(joystick2, 7);
		Button but8b = new JoystickButton(joystick2, 8);
		Button but9b = new JoystickButton(joystick2, 9);
		Button but10b = new JoystickButton(joystick2, 10);
		Button but11b = new JoystickButton(joystick2, 11);
		Button but12b = new JoystickButton(joystick2, 12);
		
		// commands to be pushed
		
		
		but11b.whileHeld(new PullIn());
		but12b.whileHeld(new PushOut());
		but1b.whileHeld(new SettingUpperLift());
		but1b.whenReleased(new StopUpperLift());
		but2b.whenPressed(new DumpAction());
	}
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
