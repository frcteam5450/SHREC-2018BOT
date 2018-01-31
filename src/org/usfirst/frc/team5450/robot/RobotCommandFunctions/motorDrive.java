package org.usfirst.frc.team5450.robot.RobotCommandFunctions;

import org.usfirst.frc.team5450.robot.Objects;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class motorDrive {
	
	public static final void teleopDrive(double leftPower , double rightPower) {
		Objects.drive0.set(-leftPower);
		SmartDashboard.putNumber("Left Back Motor", Objects.drive0.getOutputCurrent());
		Objects.drive1.set(-leftPower);
		SmartDashboard.putNumber("Left Front Motor", Objects.drive1.getOutputCurrent());
		Objects.drive2.set(rightPower);
		SmartDashboard.putNumber("Right Front Motor", Objects.drive2.getOutputCurrent());
		Objects.drive3.set(rightPower);
		SmartDashboard.putNumber("Right Back Motor", Objects.drive3.getOutputCurrent());
	}
}
