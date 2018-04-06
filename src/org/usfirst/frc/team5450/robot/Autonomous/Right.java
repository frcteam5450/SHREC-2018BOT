package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.Objects;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.Catapult;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;

public class Right {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3, 2);
	static Catapult catapult = new Catapult();
	
	public static void crossLine() {
		drive.driveStraight(.5, .05, 2.25 * (5.5/4));//originally 1.5 * (5.5/4)
	}
	
	public static void switchRight() { //commented out for safety
		drive.driveStraight(.5, .05, 3.7);
		drive.turn(.5, -90);
		drive.driveStraight(.5, .05, 1.7);
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0); 
		
		drive.stopDrive();
	}
	
	public static void scoreScaleRight() {
		catapult.stop();
		drive.driveStraight(.75, .05, 4.06); //7.5 * (5.5/4)
		Objects.timer.delay(.3);
		drive.turn(.5, -70);
		drive.driveStraight(-.35, .05, 1.25);
		drive.driveStraight(.55, .05, .1);
		//catapult.stop();
		//Objects.timer.delay(3);
		catapult.fireAuto();
	}
	
	public static void scoreScaleLeft() {//commented out for safety
		/*drive.driveStraight(.5, .05, 140/16);
		drive.turn(.5, -90);
		drive.driveStraight(.5, .05, 165/16); */
		catapult.stop();
		drive.driveStraight(.5, .05, 2.75 * (5.5/4));
		drive.stopDrive();
	}

}
