package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class LeftA {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void leftARight() {
		DriveTrain.gyro.reset();
		drive.driveStraight(.75 , 0.1 , .5);
		drive.stopDrive();
		DriveTrain.gyro.reset();
		drive.turn(.35, -90);
	}
}
