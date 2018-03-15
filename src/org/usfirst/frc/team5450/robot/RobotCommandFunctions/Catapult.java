package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team5450.robot.Objects;

public class Catapult {
	DoubleSolenoid catapultLeft = Objects.catapult0;
	DoubleSolenoid catapultRight = Objects.catapult1;
	Compressor compressor = Objects.compressor;
	
	boolean catapultState;
	
	public Catapult() {
		catapultLeft.set(Value.kReverse);
		catapultRight.set(Value.kReverse);
		catapultState = false;
	}
	
	public void fire() {
			catapultLeft.set(Value.kReverse);
			catapultRight.set(Value.kReverse);
	}
	
	public void stop() {
		catapultLeft.set(Value.kForward);
		catapultRight.set(Value.kForward);
	}
}
