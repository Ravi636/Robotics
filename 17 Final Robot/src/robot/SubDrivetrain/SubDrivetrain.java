package org.usfirst.frc.team6451.robot.subsystems;

import org.usfirst.frc.team6451.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team6451.util.ADXRS453Gyro;
/**
 *
 */
public class SubDrivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public final Victor leftMotors;
	public final Victor rightMotors;
	
	public ADXRS453Gyro gyro = new ADXRS453Gyro(); 
	
	public SubDrivetrain() {
		super("SubDrivetrain");
		
		leftMotors = new Victor(RobotMap.PWM_VICTOR_DRIVETRAIN_LEFT);
		rightMotors = new Victor(RobotMap.PWM_VICTOR_DRIVETRAIN_RIGHT);
	}
    public void initDefaultCommand() {
        
    	
    	//setDefaultCommand(new ComSplitDrive());
    	//setDefaultCommand(Robot.drive_chooser.getSelected());
    }
    
    public void setMotors(double left, double right) {
    	left = scaleLeft(left);
    	right = scaleRight(right);
    
    	setMotorsRaw(left, right);
    }
    
    private double scaleLeft(double left) {
    	return left * RobotMap.SCALE_VICTOR_DRIVETRAIN_LEFT;
    }
    
    private double scaleRight(double right) {
    	return right * RobotMap.SCALE_VICTOR_DRIVETRAIN_RIGHT;
    }
    
    private void setMotorsRaw(double left, double right) {
    	left = safetyTest(left*RobotMap.Scale_All_Drive_Motors);
    	right = safetyTest(right)*RobotMap.Scale_All_Drive_Motors;
    	
    	leftMotors.set(left);
    	rightMotors.set(right);
    	//frontRightMotor.set(right);
    	//backRightMotor.set(right);
    }
    
    private double safetyTest(double motorValue) {
    	//motorValue = (motorValue < -1) ? -1 : motorValue;
    	//motorValue = (motorValue > 1) ? 1 : motorValue;
    	motorValue = (Math.abs(motorValue) > 1) ? Math.signum(motorValue) : motorValue;
    	return motorValue;
    }
    
    
}

