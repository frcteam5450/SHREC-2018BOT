package org.usfirst.frc.team5450.robot.Autonomous;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.Objects;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;

public class Middle {
	
	static DriveTrain drive = new DriveTrain();
	static ArmFlywheel arm = new ArmFlywheel(3, 2);
	
	public static void leftSwitch() {
		//timer delay was originally .25
		//drives to correct side of switch
		drive.driveStraight(.45, .05, .35 * (5.5/4)); //originally .35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 1.12 * (5.5/4)); //1.12 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 47);
		drive.driveStraight(.4, .05, .95 * (5.5/4));//.95 * (5.5/4)
		Objects.timer.delay(.15);
		
		//fires cube into switch
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
	}
	
	public static void rightSwitch() {
		//drives to correct side of switch
		drive.driveStraight(.45, .05, .35 * 5.5/4);//.35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 1.1 * (5.5/4));//1.1 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -49);
		drive.driveStraight(.38, .05, 1.45 * (5.5/4));//1.45 * (5.5/4)
		Objects.timer.delay(.15);
		
		//fires cube into switch
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
	}
	
	public static void leftSwitch2() {
		//drives to correct side of the switch
		drive.driveStraight(.45, .05, .35 * (5.5/4)); //originally .35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 1.12 * (5.5/4)); //1.12 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 47);
		drive.driveStraight(.4, .05, .95 * (5.5/4));//.95 * (5.5/4)
		Objects.timer.delay(.15);
		
		//fires cube into switch
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
		
		//drives to second cube
		drive.driveStraight(-.55, .05, 1);
		drive.turn(.5, -45);
		drive.driveStraight(-.55, .05, 1.5);
		drive.turn(.5, 55);
		arm.setArmToDegree(80);
		arm.intakePiston.set(true);
		drive.driveStraight(.45, .05, 2);
		
		//intakes cube
		arm.intakePiston.set(false);
		arm.flywheelIn(.7);
		Objects.timer.delay(.5);
		arm.setArmToFire(true);
		
		//drives back to correct side of switch
		drive.driveStraight(-.55, .05, 1);
		drive.turn(.5, -45);
		drive.driveStraight(.55, .05, 1.5);
		drive.turn(.5, 45);
		drive.driveStraight(.55, .05, 1.1);
		
		//fires cube into switch
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0);
		
		drive.stopDrive();
	}
	
	public static void rightSwitch2() {
		//drives to correct side of switch
		drive.driveStraight(.45, .05, .35 * 5.5/4);//.35 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, 50);
		Objects.timer.delay(.15);
		drive.driveStraight(.5, .05, 1.1 * (5.5/4));//1.1 * (5.5/4)
		Objects.timer.delay(.15);
		drive.turn(.5, -49);
		drive.driveStraight(.38, .05, 1.45 * (5.5/4));//1.45 * (5.5/4)
		Objects.timer.delay(.15);
		
		//fires cube into switch
		arm.setArmToFire(true);
		arm.flywheelOut(.35);
		Objects.timer.delay(.35);
		arm.flywheelOut(0);
		
		//drives to second cube
		drive.driveStraight(-.55, .05, 1);
		drive.turn(.5, 45);
		drive.driveStraight(-.55, .05, 1.5);
		drive.turn(.5, -55);
		arm.setArmToDegree(80);
		arm.intakePiston.set(true);
		drive.driveStraight(.45, .05, 2);
		
		//intakes cube
		arm.intakePiston.set(false);
		arm.flywheelIn(.7);
		Objects.timer.delay(.5);
		arm.setArmToFire(true);
		
		//drives back to correct side of switch
		drive.driveStraight(-.55, .05, 1);
		drive.turn(.5, -45);
		drive.driveStraight(.55, .05, 1.5);
		drive.turn(.5, 45);
		drive.driveStraight(.55, .05, 1.1);
		
		//fires cube into switch
		arm.flywheelOut(.35);
		Objects.timer.delay(1);
		arm.flywheelOut(0); 
		
		drive.stopDrive();
	}
	
	public static void crossLine() {
		drive.stopDrive();
	}
}
