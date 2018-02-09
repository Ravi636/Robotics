package org.usfirst.frc.team6451.robot.commands;

import org.usfirst.frc.team6451.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ComSplitDrive extends Command {

    public ComSplitDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.drivetrainSubsystem);
    }

    
    boolean reverse;
    
    // Called just before this Command runs the first time
    protected void initialize() {
    	reverse = false;
    	Robot.drivetrainSubsystem.setMotors(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double y = Robot.m_oi.getLeftStickY();
    	double x = -Robot.m_oi.getRightStickX();
    	double trigger = Robot.m_oi.getLeftTrigger()-Robot.m_oi.getRightTrigger();
    	double vl, vr;    //left and right wheel velocities
    	double temp = 0;
    	
    	if (trigger!=0) {		//check for quickturn first
    		vl = -trigger;		//left trigger = 0 to 1
    		vr = trigger;		//right trigger = 0 to 1
    	} else if (x>=0) {		
    		vl = y;
    		vr = y*(1-x);		//if no quickturn, drive based on y and x joysticks
    		
    		if (reverse) {		//swaps vl and vr
    			temp = vl;
    			vl = -vr;
    			vr = -temp;
    		}
    		
    	} else {
    		vl = y*(1+x);		//comments for above "if" apply to this one too
    		vr = y;
    		
    		if (reverse) {
    			temp = vl;
    			vl = -vr;
    			vr = -temp;
    		}
    		
    	}
    	
    	Robot.drivetrainSubsystem.setMotors(vl, vr);
    	
    	
    	if (Robot.m_oi.xbox.getRawButtonPressed(7)) {
    		reverse= !reverse;
    	}
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
