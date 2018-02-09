/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6451.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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
	
	
	///*
	public Joystick xbox = new Joystick(RobotMap.PORT_GAMECONTROLLER);
	JoystickButton butA = new JoystickButton(xbox, 1);
	JoystickButton butB = new JoystickButton(xbox, 2);
	JoystickButton butX = new JoystickButton(xbox, 3);
	JoystickButton butY = new JoystickButton(xbox, 4);
	JoystickButton butLB = new JoystickButton(xbox, 5);
	JoystickButton butRB = new JoystickButton(xbox, 6);
	public JoystickButton butBack = new JoystickButton(xbox, 7);
	JoystickButton butStart = new JoystickButton(xbox, 8);
	JoystickButton butLS = new JoystickButton(xbox, 9);
	JoystickButton butRS = new JoystickButton(xbox, 10);
	
	public double getLeftStickX() {return stickDeadZoneScale(xbox.getRawAxis(2));}
	public double getLeftStickY() {return stickDeadZoneScale(xbox.getRawAxis(1));}
	public double getRightStickX() {return stickDeadZoneScale(xbox.getRawAxis(4));}
	public double getRightStickY() {return stickDeadZoneScale(xbox.getRawAxis(5));}
	public double getLeftTrigger() {return stickDeadZoneScale(xbox.getRawAxis(2));}
	public double getRightTrigger() {return stickDeadZoneScale(xbox.getRawAxis(3));}
	//*/
	/*
	private Joystick ps = new Joystick(RobotMap.PORT_GAMECONTROLLER);
	public double getLeftStickX() {return stickDeadZoneScale(ps.getRawAxis(0));}
	public double getLeftStickY() {return stickDeadZoneScale(ps.getRawAxis(1));}
	public double getRightStickX() {return stickDeadZoneScale(ps.getRawAxis(2));}
	public double getRightStickY() {return stickDeadZoneScale(ps.getRawAxis(3));}
	public double getTriggers() {return (ps.getRawButton(7)) ? 0:1;}
	*/
	private double stickDeadZoneScale (double input) {
		return (Math.abs(input) < RobotMap.CONSTANT_STICK_DEADZONE) ? 0 : Math.signum(input)*(Math.abs(input)-RobotMap.CONSTANT_STICK_DEADZONE)/(1-RobotMap.CONSTANT_STICK_DEADZONE);
	}
	
	
	
	
	public OI() {
		
	}
}
