package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.Objects;

public class LeftA {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void leftARight() {
		drive.driveStraight(.5 , .01 , 4);
		drive.stopDrive();
	}
}
