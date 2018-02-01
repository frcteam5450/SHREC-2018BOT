package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class ArmPivot {
	
	WPI_TalonSRX armPivotMotor = Objects.armPivot;
	WPI_TalonSRX flywheelLeft = Objects.flywheelLeft;
	WPI_TalonSRX flywheelRight = Objects.flywheelRight;
	
	int initArmPos;
	int armPos;
	int armSetPoint;
	
	Joystick control = Objects.controller;
	
	public ArmPivot() {
		armPivotMotor.set(0);
		flywheelLeft.set(0);
		flywheelRight.set(0);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = 0;
		armSetPoint = 0;
	}
	
	public void setArm(int increment , double gain) {
		if (control.getRawButton(5) == true) {
			armSetPoint = armSetPoint - increment;
			Objects.timer.delay(.1);
		}
		
		if (control.getRawButton(6) == true) {
			armSetPoint = armSetPoint + increment;
			Objects.timer.delay(.1);
		}
		
		int armError = armSetPoint - initArmPos;
		double armPower = armError * gain;
		armPivotMotor.set(armPower);
		
	}
	
	public void flyWheel(int intakeAxis, int outtakeAxis) {
		
	}
	
	public void setInitArmPos() {
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
	}
}
