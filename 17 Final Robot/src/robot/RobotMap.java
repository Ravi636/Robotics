/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6451.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	
	//classifiers PORT, PWM, SCALE, CONSTANT, ...
	
	public static final int PORT_GAMECONTROLLER = 2;
	
	public static final int PWM_VICTOR_DRIVETRAIN_LEFT = 1;
	public static final int PWM_VICTOR_DRIVETRAIN_RIGHT = 0;
	
	public static final int NODE_COMPRESSOR = 0;
	public static final int NODE_DOUBLE_SOL_1a = 0;
	public static final int NODE_DOUBLE_SOL_1b = 1;
	
	public static final double SCALE_VICTOR_DRIVETRAIN_LEFT = 1.0;
	public static final double SCALE_VICTOR_DRIVETRAIN_RIGHT = -1.0;
	public static double Scale_All_Drive_Motors = 1.0;
	
	public static final double CONSTANT_STICK_DEADZONE = .08;
	
}
