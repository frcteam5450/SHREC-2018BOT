package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmFlywheel extends ArmPivot {
	
	WPI_TalonSRX flywheelLeft = Objects.flywheelLeft;
	WPI_TalonSRX flywheelRight = Objects.flywheelRight;
	public Solenoid intakePiston = Objects.climbPiston;
	
	int iAxis = 2;
	int oAxis = 3;
	boolean pistonState = false;
	
	public ArmFlywheel(int intakeAxis , int outtakeAxis) {
		iAxis = intakeAxis;
		oAxis = outtakeAxis;
		
		armPivotMotor.set(0);
		intakePiston.set(false);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = initArmPos;
		armSetPoint = armPos;
	}
	
	public void flywheel() {
		double inSpeed1 = control.getRawAxis(iAxis);
		double inSpeed2 = Objects.controller2.getRawAxis(iAxis);
		double outSpeed1 = control.getRawAxis(oAxis);
		double outSpeed2 = Objects.controller2.getRawAxis(oAxis);
		
		double inSpeed;
		double outSpeed;
		
		if (inSpeed2 > inSpeed1)
			inSpeed = inSpeed2 * .7;
		else
			inSpeed = inSpeed1 * .7;
		
		if (outSpeed2 > outSpeed1)
			outSpeed = outSpeed2 * 1;
		else
			outSpeed = outSpeed1 * 1;
		
		if (inSpeed > 0.1) {
			flywheelLeft.set(inSpeed);
			flywheelRight.set(inSpeed);
		}
		
		if (outSpeed > 0.1) {
			flywheelLeft.set(-outSpeed);
			flywheelRight.set(-outSpeed);
		}
		
		if (outSpeed <= 0.1 && inSpeed <= 0.1) {
			flywheelLeft.set(0.1);
			flywheelRight.set(0.1);
		}
	}
	
	public void flywheelIn(double speed) {
		flywheelLeft.set(speed);
		flywheelRight.set(speed);
	}
	
	public void flywheelOut(double speed) {
		flywheelLeft.set(-speed);
		flywheelRight.set(-speed);
		//flywheelLeft.set(0);
		//flywheelRight.set(0);
	}
	
	public void displayStats() {
		SmartDashboard.putNumber("Encoder Raw",armPivotMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Encoder Degree:", getArmDegree());
		SmartDashboard.putNumber("Arm Pivot Motor", armPivotMotor.getOutputCurrent());
		SmartDashboard.putNumber("Left Flywheel", flywheelLeft.getOutputCurrent());
		SmartDashboard.putNumber("Right Flywheel", flywheelRight.getOutputCurrent());
	}
	
	public void togglePiston() {
		pistonState = !pistonState;
		intakePiston.set(pistonState);
	}
}
