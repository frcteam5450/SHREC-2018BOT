<<<<<<< HEAD
<<<<<<< HEAD
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
=======
package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team5450.robot.Objects;

public class Catapult {
	DoubleSolenoid catapultLeft = Objects.catapult0;
	DoubleSolenoid catapultRight = Objects.catapult1;
	Compressor compressor = Objects.compressor;
	
	public Catapult() {
		catapultLeft.set(Value.kOff);
		catapultRight.set(Value.kOff);
	}
	
	public void fire(double delay) {
		
		catapultLeft.set(Value.kReverse);
		catapultRight.set(Value.kReverse);
		
		compressor.start();
		Objects.timer.delay(delay);
		
		catapultLeft.set(Value.kForward);
		catapultRight.set(Value.kForward);
		
	}
	
	public void stop() {
		catapultLeft.set(Value.kForward);
		catapultRight.set(Value.kForward);
	}
}
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
=======
package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team5450.robot.Objects;

public class Catapult {
	DoubleSolenoid catapultLeft = Objects.catapult0;
	DoubleSolenoid catapultRight = Objects.catapult1;
	Compressor compressor = Objects.compressor;
	
	public Catapult() {
		catapultLeft.set(Value.kOff);
		catapultRight.set(Value.kOff);
	}
	
	public void fire(double delay) {
		
		catapultLeft.set(Value.kReverse);
		catapultRight.set(Value.kReverse);
		
		compressor.start();
		Objects.timer.delay(delay);
		
		catapultLeft.set(Value.kForward);
		catapultRight.set(Value.kForward);
		
	}
	
	public void stop() {
		catapultLeft.set(Value.kForward);
		catapultRight.set(Value.kForward);
	}
}
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
