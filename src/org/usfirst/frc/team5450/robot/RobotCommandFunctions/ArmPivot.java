package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmPivot {
	
	WPI_TalonSRX armPivotMotor = Objects.armPivot;
	
	
	int initArmPos;
	int armPos;
	int armSetPoint;
	int armVelSetPoint = 0;
	int armVel;
	
	Joystick control = Objects.controller;
	
	
	public ArmPivot() {
		armPivotMotor.set(0);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = 0;
		armSetPoint = armPos;
	}
	
	public void setArm(int increment , double gain) {
		if (control.getRawButton(6) == true) {
			armVelSetPoint = -200;//armSetPoint - increment;
			//Objects.timer.delay(.25);
		}
		
		if (control.getRawButton(5) == true) {
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
	
	
	public void setInitArmPos() {
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = 0;
		armSetPoint = armPos;
	}
	
	public void displayArmPos() {
		
	}
}
