package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;

public class DriveTrain {
	
	WPI_TalonSRX driveLeft1 = Objects.driveLeft1;
	WPI_TalonSRX driveLeft2 = Objects.driveLeft2;
	WPI_TalonSRX driveRight1 = Objects.driveRight1;
	WPI_TalonSRX driveRight2 = Objects.driveRight2;
	
	ADXRS450_Gyro gyro = new ADXRS450_Gyro();
	
	Encoder encoder = Objects.driveEnc;
	
	Solenoid shift1 = Objects.driveLeftShift;
	Solenoid shift2 = Objects.driveRightShift;
	boolean gearState = false;
	
	Joystick joy = Objects.controller;
	int lControl = 1;
	int rControl = 5;
	int gearShift;
	
	double multiplier = .7;
	
	public DriveTrain(double k , WPI_TalonSRX motor1 , WPI_TalonSRX motor2 , WPI_TalonSRX motor3 , WPI_TalonSRX motor4 , Solenoid lShift , Solenoid rShift) {
		multiplier = k;
		driveLeft1 = motor1;
		driveLeft2 = motor2;
		driveRight1 = motor3;
		driveRight2 = motor4;
		shift1 = lShift;
		shift2 = rShift;
		
		encoder.reset();
		encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
	}
	
	public DriveTrain(int leftControlAxis , int rightControlAxis , int gear) {
		lControl = leftControlAxis;
		rControl = rightControlAxis;
		gearShift = gear;
	}
	
	public DriveTrain() {
		
	}
	
	public void setPower(double kMultiplier) {
		multiplier = kMultiplier;
		
		double leftPower = (joy.getRawAxis(lControl)) * multiplier;
		double rightPower = (joy.getRawAxis(rControl)) * multiplier;
		
		driveLeft1.set(-leftPower);
		driveLeft2.set(-leftPower);
		driveRight1.set(rightPower);
		driveRight2.set(rightPower);
	}
	
	public void stopDrive() {
		driveRight2.set(0);
		driveLeft1.set(0);
		driveLeft2.set(0);
		driveRight1.set(0);
	}
	
	public void shift() {
		shift1.set(!gearState);
		shift2.set(!gearState);
		gearState = !gearState;
	}
	
	public long getDegrees() {
		return encoder.get();
	}
	
	public void driveStraight(double motorPower , double correction , double time) {
		while (Objects.timer.get() < time) {
		double degree = gyro.getAngle();
		double rightPower = motorPower - (degree * correction);
		
		driveLeft1.set(motorPower);
		driveLeft2.set(motorPower);
		driveRight1.set(-rightPower);
		driveRight2.set(-rightPower);
		}
	}
	
	public void showCurrent() {
		SmartDashboard.putNumber("Back Left Drive Current", driveLeft1.getOutputCurrent());
		SmartDashboard.putNumber("Front Left Drive Current", driveLeft2.getOutputCurrent());
		SmartDashboard.putNumber("Back Right Drive Current", driveRight1.getOutputCurrent());
		SmartDashboard.putNumber("Front Right Drive Current", driveRight2.getOutputCurrent());
	}
}
