package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
<<<<<<< HEAD
=======
import org.usfirst.frc.team5450.robot.Objects;
>>>>>>> bd84e7d5faee94b050f4da1a7795772740b30476

public class LeftA {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void leftARight() {
<<<<<<< HEAD
		DriveTrain.gyro.reset();
		drive.driveStraight(.75 , 0.1 , .5);
		drive.stopDrive();
		DriveTrain.gyro.reset();
		drive.turn(.35, -90);
=======
		drive.driveStraight(.5 , .01 , 4);
		drive.stopDrive();
>>>>>>> bd84e7d5faee94b050f4da1a7795772740b30476
	}
}
