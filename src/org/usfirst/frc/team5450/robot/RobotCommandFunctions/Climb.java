package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5450.robot.Objects;

public class Climb {
	WPI_TalonSRX extenderWinch = Objects.extenderWinch;
	WPI_TalonSRX climbingWinch = Objects.climbingWinch;
	Encoder enc = Objects.climbEnc;
	Solenoid piston = Objects.climbPiston;
	boolean pistonState = false;
	
	public Climb() {
		extenderWinch.set(0);
		climbingWinch.set(0);
		piston.set(pistonState);
		enc.reset();
	}
	
	public void extendArm() {
		extenderWinch.set(1);
	}
	
	public void retractArm() {
		extenderWinch.set(-0.5);
	}
	
	public void stopExtend() {
		extenderWinch.set(0);
	}
	
	//need to make a down extend - Ford changed the climb to make this work
	
	public void climb() {
		climbingWinch.set(-1);
	}
	
	public void stopClimb() {
		climbingWinch.set(0);
	}
	
	public void extendClimb() {
		climbingWinch.set(1);
	}
	
	/*public void pistonClimb() {
		pistonState = !pistonState;
		piston.set(pistonState);
	}*/
	
	public void displayStats() {
		SmartDashboard.putNumber("Climb Encoder", enc.getRaw());
	}
	
	
}
