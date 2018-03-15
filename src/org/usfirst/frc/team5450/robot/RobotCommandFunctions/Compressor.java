package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;

public class Compressor {
	Relay relay = Objects.compRelay;
	
	public Compressor() {
		set(false);
	}
	
	public void set() {
		if (Objects.compressor.enabled())
			/*relay.set(Value.kForward)*/;
		else
			relay.set(Value.kOff);
	}
	
	public void set(boolean state) {
		if (state)
			/*relay.set(Value.kForward)*/;
		else
			relay.set(Value.kOff);
	}
}
