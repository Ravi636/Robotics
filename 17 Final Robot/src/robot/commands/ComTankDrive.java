package org.usfirst.frc.team6451.robot.commands;

import org.usfirst.frc.team6451.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ComTankDrive extends Command {

    public ComTankDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrainSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrainSubsystem.setMotors(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrainSubsystem.setMotors(Robot.m_oi.getLeftStickY(), Robot.m_oi.getRightStickY());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
