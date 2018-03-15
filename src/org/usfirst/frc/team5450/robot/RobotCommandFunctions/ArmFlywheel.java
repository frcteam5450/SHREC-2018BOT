package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
<<<<<<< HEAD
		double inSpeed = .70 *control.getRawAxis(iAxis);
		double outSpeed = .60 * control.getRawAxis(oAxis);
=======
		double inSpeed = .75 *control.getRawAxis(iAxis);
		double outSpeed = .75 * control.getRawAxis(oAxis);
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		
		if (inSpeed > 0.1) {
			flywheelLeft.set(inSpeed);
			flywheelRight.set(inSpeed);
		}
		
		if (outSpeed > 0.1) {
			flywheelLeft.set(-outSpeed);
			flywheelRight.set(-outSpeed);
		}
		
		if (outSpeed <= 0.1 && inSpeed <= 0.1) {
<<<<<<< HEAD
			flywheelLeft.set(0.1);
			flywheelRight.set(0.1);
=======
			flywheelLeft.set(0.075);
			flywheelRight.set(0.075);
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		}
	}
	
	public void flywheelIn(double speed) {
		flywheelLeft.set(speed);
		flywheelRight.set(speed);
	}
	
	public void flywheelOut(double speed) {
		flywheelLeft.set(-speed);
		flywheelRight.set(-speed);
		Objects.timer.delay(2.5);
		flywheelLeft.set(0);
		flywheelRight.set(0);
	}
	
	public void displayStats() {
		SmartDashboard.putNumber("Encoder Raw",armPivotMotor.getSelectedSensorPosition(0));
		SmartDashboard.putNumber("Encoder Degree:", getArmDegree());
		SmartDashboard.putNumber("Arm Pivot Motor", armPivotMotor.getOutputCurrent());
		SmartDashboard.putNumber("Left Flywheel", flywheelLeft.getOutputCurrent());
		SmartDashboard.putNumber("Right Flywheel", flywheelRight.getOutputCurrent());
	}
}
