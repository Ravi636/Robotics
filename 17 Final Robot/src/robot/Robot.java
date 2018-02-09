/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6451.robot;

import org.usfirst.frc.team6451.robot.commands.ComDriveStraight;
import org.usfirst.frc.team6451.robot.commands.ComSplitDrive;
import org.usfirst.frc.team6451.robot.commands.ComTankDrive;
import org.usfirst.frc.team6451.robot.subsystems.SubDrivetrain;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	public static OI m_oi;
	
	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	//
	
	public static SubDrivetrain drivetrainSubsystem;
	
	

	Command drive;
	
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//initialize these first (subsystems and OI)
		drivetrainSubsystem = new SubDrivetrain();
		m_oi = new OI();
		drivetrainSubsystem.gyro.calibrate();
		drive = new ComSplitDrive();
		
		m_chooser.addDefault("Drive Straight", new ComDriveStraight());
		m_chooser.addObject("Default Auto2", new ComTankDrive());
		m_chooser.addObject("Default Auto3", new ComTankDrive());
		SmartDashboard.putData("Auto mode", m_chooser);

		SmartDashboard.putNumber("Gyro value", drivetrainSubsystem.gyro.getAngle());
		SmartDashboard.putNumber("Gyro rate", drivetrainSubsystem.gyro.getRate());
		SmartDashboard.putNumber("Gyro drift", drivetrainSubsystem.gyro.driftRate);
		SmartDashboard.putData(Scheduler.getInstance());
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		drivetrainSubsystem.gyro.calibrate();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		if (drivetrainSubsystem.gyro.isCalibrating()) drivetrainSubsystem.gyro.stopCalibrating();
		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}

    	Robot.drivetrainSubsystem.gyro.reset();
    	Robot.drivetrainSubsystem.gyro.startThread();
		drive.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		SmartDashboard.putNumber("Left Drive Motor", drivetrainSubsystem.leftMotors.getSpeed());
	    SmartDashboard.putNumber("Right Drive Motor", drivetrainSubsystem.rightMotors.getSpeed());
	   	Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
