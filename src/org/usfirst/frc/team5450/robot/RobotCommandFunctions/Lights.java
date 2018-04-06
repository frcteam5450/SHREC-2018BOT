package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;

public class Lights {
	DigitalOutput out1 = new DigitalOutput(7);
	DigitalOutput out2 = new DigitalOutput(8);
	DigitalOutput out3 = new DigitalOutput(9);
	
	public Lights() {
		out1.set(true);
		out2.set(true);
		out3.set(true);
	}
	
	public void setLights(String state) {
		
		switch (state) {
			case "highGear":
				out1.set(false);
				out2.set(true);
				//out3.set(false);
				break;
			case "lowGear":
				out1.set(true);
				out2.set(false);
				//out3.set(false);
				break;
			case "catapultFire":
				out1.set(false);
				out2.set(false);
				//out3.set(false);
				break;
			case "idle":
			default:
				out1.set(true);
				out2.set(true);
				//out3.set(true);
		}
	}
	
	public void setColor(DriverStation.Alliance color) {
		if (color == Alliance.Red)
			out3.set(true);
		else
			out3.set(false);
	}
}
