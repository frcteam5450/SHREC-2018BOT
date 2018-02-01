package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ArmFlywheel extends ArmPivot {
	
	WPI_TalonSRX flywheelLeft = Objects.flywheelLeft;
	WPI_TalonSRX flywheelRight = Objects.flywheelRight;
	
	int iAxis = 2;
	int oAxis = 3;
	
	public ArmFlywheel(int intakeAxis , int outtakeAxis) {
		iAxis = intakeAxis;
		oAxis = outtakeAxis;
		
		armPivotMotor.set(0);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = initArmPos;
		armSetPoint = armPos;
	}
	
	public void flywheel() {
		double inSpeed = control.getRawAxis(iAxis);
		double outSpeed = control.getRawAxis(oAxis);
		
		if (inSpeed > 0.1) {
			flywheelLeft.set(-inSpeed);
			flywheelRight.set(inSpeed);
		}
		
		if (outSpeed > 0.1) {
			flywheelLeft.set(outSpeed);
			flywheelRight.set(-outSpeed);
		}
		
		if (outSpeed <= 0.1 && inSpeed <= 0.1) {
			flywheelLeft.set(0);
			flywheelRight.set(0);
		}
	}
}
