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
		drive.driveStraight(.5, .05, 33/16);//originally 1.5 * (5.5/4)
	}
	
	public static void switchRight() { //commented out for safety
		/*drive.driveStraight(.5, .05, 27/16);
		drive.turn(.5, -90);
		drive.driveStraight(.5, .05, 1.2);
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0); */
		
		drive.stopDrive();
	}
	
	public static void scoreScaleRight() {
		drive.driveStraight(.5, .05, 165/16);//7.5 * (5.5/4)
		drive.turn(.5, -90);
		drive.driveStraight(-.5, .05, .5);
		drive.driveStraight(.5, .05, .1);
		catapult.stop();
		Objects.timer.delay(1);
		catapult.fire();
	}
	
	public static void scoreScaleLeft() {//commented out for safety
		/*drive.driveStraight(.5, .05, 140/16);
		drive.turn(.5, -90);
		drive.driveStraight(.5, .05, 165/16); */
		
		drive.stopDrive();
	}

}
