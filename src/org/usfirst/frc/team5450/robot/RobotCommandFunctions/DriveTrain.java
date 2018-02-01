package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class DriveTrain {
	
	WPI_TalonSRX drive1 = Objects.drive0;
	WPI_TalonSRX drive2 = Objects.drive1;
	WPI_TalonSRX drive3 = Objects.drive2;
	WPI_TalonSRX drive4 = Objects.drive3;
	
	Solenoid shift1 = Objects.driveLeftShift;
	Solenoid shift2 = Objects.driveRightShift;
	boolean gearState = false;
	
	Joystick joy = Objects.controller;
	int lControl = 1;
	int rControl = 5;
	int gearShift;
	
	double multiplier = .5;
	
	public DriveTrain(double k , WPI_TalonSRX motor1 , WPI_TalonSRX motor2 , WPI_TalonSRX motor3 , WPI_TalonSRX motor4 , Solenoid lShift , Solenoid rShift) {
		multiplier = k;
		drive1 = motor1;
		drive2 = motor2;
		drive3 = motor3;
		drive4 = motor4;
		shift1 = lShift;
		shift2 = rShift;
	}
	
	public DriveTrain(int leftControlAxis , int rightControlAxis , int gear) {
		lControl = leftControlAxis;
		rControl = rightControlAxis;
		gearShift = gear;
	}
	
	public void setPower() {
		double leftPower = (joy.getRawAxis(lControl)) * multiplier;
		double rightPower = (joy.getRawAxis(rControl)) * multiplier;
		
		drive1.set(-leftPower);
		drive2.set(-leftPower);
		drive3.set(rightPower);
		drive4.set(rightPower);
	}
	
	public void setPower(double leftPower , double rightPower) {
		drive1.set(-leftPower);
		drive2.set(-leftPower);
		drive3.set(rightPower);
		drive4.set(rightPower);
	}
	
	public void setMultiplier(double newVal) {
		multiplier = newVal;
	}
	
	public void stopDrive() {
		drive4.set(0);
		drive1.set(0);
		drive2.set(0);
		drive3.set(0);
	}
	
	public void shift() {
		shift1.set(!gearState);
		shift2.set(!gearState);
		gearState = !gearState;
	}
}
