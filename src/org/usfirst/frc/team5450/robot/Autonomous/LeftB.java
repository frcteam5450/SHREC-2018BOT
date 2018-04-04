package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class LeftB {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void leftB() {
		drive.driveStraight(.75 , 0.1 , 4);
		drive.turn(.75, -90);
		drive.driveStraight(.75, 0.1, 3.5);
		drive.turn(.75, 90);
		drive.driveStraight(.75, .1, 8);
		
	}
}
