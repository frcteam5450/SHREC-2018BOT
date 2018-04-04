package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ArmPivot {
	
	WPI_TalonSRX armPivotMotor = Objects.armPivot;
	
	
	int armPosition = 1;
	int initArmPos;
	int armPos;
	int armSetPoint;
	int armVelSetPoint = 0;
	int armVel;
	
	int armLoadPos = 0;
	int armShootPos = 90;
	int armExchangePos = 135;
	int armIntakePos = 180;
	
	Joystick control = Objects.controller;
	public static Timer timer = new Timer();
    public boolean testBool=DriverStation.getInstance().isAutonomous();
	
	public ArmPivot() {
		armPivotMotor.set(0);
		
		initArmPos = armPivotMotor.getSelectedSensorPosition(0);
		armPos = 0;
		armSetPoint = armPos;
	}
	
	public void setArm(int increment , double gain) {
		if (control.getRawButton(5) == true || Objects.controller2.getRawButton(5) == true) {
			armVelSetPoint = -200;//armSetPoint - increment;
			//Objects.timer.delay(.25);
		}
		
		if (control.getRawButton(6) == true || Objects.controller2.getRawButton(6) == true) {
			armVelSetPoint = 200;//armSetPoint + increment;
			//Objects.timer.delay(.25);
		}
		
		if (control.getRawButton(6) == false && control.getRawButton(5) == false && Objects.controller2.getRawButton(6) == false && Objects.controller2.getRawButton(5) == false)
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
		//armPos = 0;
		//armSetPoint = armPos;
	}
	
	public double getArmDegree() {
		double degree = (armPivotMotor.getSelectedSensorPosition(0) - initArmPos) * .0023809;
		return degree;
	}
	
	public void setArmToInit() {
		double power = getArmDegree() * .01;
		armPivotMotor.set(power);
	}
	
	public void setArmToFire(boolean wait) {
		if (wait) {
			while (testBool && getArmDegree() <= 50) {
				double power = (getArmDegree() - 60) * .05;
				armPivotMotor.set(power);
				
		        //updates testBool
		        testBool=DriverStation.getInstance().isAutonomous();
		        //added a 10 msec delay
		        timer.delay(0.010);
			}
			armPivotMotor.set(0);
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
	}
}
