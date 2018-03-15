package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class Left {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3, 2);
	
	public static void crossLine() {
		drive.driveStraight(.75, .01, 10);
	}
	
	public static void switchLeft() {
		drive.driveStraight(.75, .01, 12);
		drive.turn(.75, 90);
		drive.driveStraight(.75, .01, 3);
	}
	
	public static void scoreScaleLeft() {
		drive.driveStraight(.75, .01, 22);
	}
	
	public static void scoreScaleRight() {
		drive.driveStraight(.75, .01, 17);
		drive.turn(.75, 90);
		drive.driveStraight(.75, .01, 14);
	}

}
