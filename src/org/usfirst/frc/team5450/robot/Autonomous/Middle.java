package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;

public class Middle {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3, 2);
	
	public static void leftSwitch() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, .01, 2);
		drive.turn(.75, -50);
		drive.driveStraight(.75, .01, 6.5);
		drive.turn(.75, 35);
		arm.flywheelOut(.65);
	}
	
	public static void rightSwitch() {
		arm.setArmToFire(true);
		drive.driveStraight(.75, .01, 2);
		drive.turn(.75, 50);
		drive.driveStraight(.75, .01, 6.5);
		drive.turn(.75, -35);
		arm.flywheelOut(.65);
	}
	
	public static void crossLine() {
		
	}
}
