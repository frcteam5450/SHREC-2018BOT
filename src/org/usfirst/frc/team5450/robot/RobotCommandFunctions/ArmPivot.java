package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;

public class ArmPivot {
	
	WPI_TalonSRX armPivotMotor = Objects.armPivot;
	
	
	int initArmPos;
	int armPos;
	int armSetPoint;
	
	Joystick control = Objects.controller;
	
	
	public ArmPivot() {
		armPivotMotor.set(0);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = initArmPos;
		armSetPoint = armPos;
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
	
	
	public void setInitArmPos() {
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = initArmPos;
		armSetPoint = armPos;
	}
}
