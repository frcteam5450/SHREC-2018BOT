package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.Objects;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;

public class Middle {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3, 2);
	
	public static void leftSwitch() {
		//timer delay was originally .25
		drive.driveStraight(.45, .05, 77/160); //originally .35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 77/50); //1.12 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 47);
		drive.driveStraight(.4, .05, 209/160);//.95 * (5.5/4)
		Objects.timer.delay(.15);
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
	}
	
	public static void rightSwitch() {
		drive.driveStraight(.45, .05, 77/160);//.35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 121/80);//1.1 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -49);
		drive.driveStraight(.38, .05, 319/160);//1.45 * (5.5/4)
		Objects.timer.delay(.15);
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
	}
	
	public static void crossLine() {
		drive.stopDrive();
	}
}
