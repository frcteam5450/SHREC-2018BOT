package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;

public class LeftASwitch {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3 , 2);
	
	public static void left() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, .1, 1);
		drive.turn(.75, 25);
		drive.driveStraight(.75, .1, 10);
		arm.flywheelOut(.65);
	}
	
	public static void right() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, .1, 4);
		drive.turn(.75, 90);
		drive.driveStraight(.75, .1, 13);
		drive.turn(.75, -90);
		drive.driveStraight(.75, .1, 7);
		arm.flywheelOut(.65);
	}
}
