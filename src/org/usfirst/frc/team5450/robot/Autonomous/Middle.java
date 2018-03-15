<<<<<<< HEAD
<<<<<<< HEAD
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
=======
package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class Middle {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void middle() {
		
	}
}
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
=======
package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class Middle {
	
	static DriveTrain drive = new DriveTrain();
	
	public static void middle() {
		
	}
}
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
