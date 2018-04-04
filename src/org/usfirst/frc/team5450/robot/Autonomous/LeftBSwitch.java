package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class LeftBSwitch {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3 , 2);
	
	public static void left() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, 0.1, 9.5);
		arm.flywheelOut(.65);
	}
	
	public static void right() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, 0.1, 4.5);
		drive.turn(.75, 90);
		drive.driveStraight(.75, 0.1, 8.7);
		drive.turn(.75, -90);
		drive.driveStraight(.75, 0.1, 5);
		arm.flywheelOut(.65);
	}
}
