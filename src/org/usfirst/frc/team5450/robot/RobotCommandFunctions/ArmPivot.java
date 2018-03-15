package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmPivot {
	
	WPI_TalonSRX armPivotMotor = Objects.armPivot;
	
	
	int armPosition = 1;
	int initArmPos = -1700;
	int armPos;
	int armSetPoint;
	int armVelSetPoint = 0;
	int armVel;
<<<<<<< HEAD
	
	int armLoadPos = 0;
	int armShootPos = 90;
	int armExchangePos = 135;
	int armIntakePos = 180;
=======
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	
	Joystick control = Objects.controller;
	
	
	public ArmPivot() {
		armPivotMotor.set(0);
		
<<<<<<< HEAD
		//initArmPos = armPivotMotor.getSelectedSensorPosition(0);
=======
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		armPos = 0;
		armSetPoint = armPos;
	}
	
	public void setArm(int increment , double gain) {
<<<<<<< HEAD
		if (control.getRawButton(5) == true) {
=======
		if (control.getRawButton(6) == true) {
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
			armVelSetPoint = -200;//armSetPoint - increment;
			//Objects.timer.delay(.25);
		}
		
<<<<<<< HEAD
		if (control.getRawButton(6) == true) {
=======
		if (control.getRawButton(5) == true) {
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
			armVelSetPoint = 200;//armSetPoint + increment;
			//Objects.timer.delay(.25);
		}
		
		if (control.getRawButton(6) == false && control.getRawButton(5) == false)
			armVelSetPoint = 0;
		
		int armError = -(armVelSetPoint - armVel);
		double armPower = armError * gain;
		armPivotMotor.set(armPower);
		armPos = armPivotMotor.getSelectedSensorPosition(0) - initArmPos;
		
	/*	int armError = -(armSetPoint - armPos);
		double armPower = armError * gain;
		armPivotMotor.set(armPower);
		armPos = armPivotMotor.getSelectedSensorPosition(0) - initArmPos;
		*/
		SmartDashboard.putNumber("Pivot Motor Velocity", armPivotMotor.getSelectedSensorVelocity(0));
		SmartDashboard.putNumber("Pivot Motor Power", armPower);
	}
	
	public void setArmLock(int dPadPos) {
		switch (dPadPos) {
			case 0:
				armPosition = 1;
				break;
			case 90:
				armPosition = 2;
				break;
			case 180:
				armPosition = 3;
				break;
			case 270:
				armPosition = 4;
				break;
			case -1:
			default:
		}
		
		switch (armPosition) {
			case 1:
				setArmToInit();
				break;
			case 2:
				setArmToFire(false);
				break;
			case 3:
				setArmToExchange();
				break;
			case 4:
				setArmToIntake();
		}
	}
	
	public void setInitArmPos() {
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = 0;
		armSetPoint = armPos;
	}
	
<<<<<<< HEAD
	public double getArmDegree() {
		double degree = (-initArmPos + armPivotMotor.getSelectedSensorPosition(0)) * .0023809;
		return degree;
	}
	
	public void setArmToInit() {
		double power = getArmDegree() * .01;
		armPivotMotor.set(power);
	}
	
	public void setArmToFire(boolean wait) {
		if (wait) {
			while (getArmDegree() <= 85 || getArmDegree() >= 95) {
				double power = (getArmDegree() - 90) * .01;
				armPivotMotor.set(power);
			}
		}
		else {
			double power = (getArmDegree() - 90) * .01;
			armPivotMotor.set(power);
		}
	}
	
	public void setArmToExchange() {
		double power = (getArmDegree() - 135) * .01;
		armPivotMotor.set(power);
	}
	
	public void setArmToIntake() {
		double power = (getArmDegree() - 180) * .01;
		armPivotMotor.set(power);
=======
	public void displayArmPos() {
		
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	}
}
