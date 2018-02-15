/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import org.usfirst.frc.team5450.robot.Objects;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.DriveTrain;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.ArmFlywheel;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.Catapult;

import autonomous.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */



public class Robot extends IterativeRobot {
	private static final String defaultAuto = "Default";
	private static final String leftA = "Left A";
	private static final String leftB = "Left B";
	private static final String middle = "Middle";
	private static final String right = "Right";
	
	private static final String leftASwitch = "Left A Switch";
	private static final String leftBSwitch = "Left B Switch";
	private static final String middleSwitch = "Middle Switch";
	private static final String rightSwitch = "Right Switch";
	
	private String m_autoSelected;
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	DriveTrain drive = new DriveTrain(1 , 5 , 1);
	
	ArmFlywheel arm = new ArmFlywheel(2 , 3);
	
	Catapult catapult = new Catapult();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.addDefault("Default Auto - Does Nothing", defaultAuto);
		m_chooser.addObject("Left A - Drives Forward", leftA);
		m_chooser.addObject("Left B - Turns Left, Drives Forward", leftB);
		m_chooser.addObject("Middle - Turns Right, Drives Forward", middle);
		m_chooser.addObject("Right - Drives Forward", right);
		
		m_chooser.addObject("Left A Switch - Places Cube in Switch", leftASwitch);
		m_chooser.addObject("Left B Switch - Places Cube in Switch", leftBSwitch);
		m_chooser.addObject("Middle Switch - Places Cube in Switch", middleSwitch);
		m_chooser.addObject("Right Switch - Places Cube in Switch", rightSwitch);
		
		SmartDashboard.putData("Auto choices", m_chooser);
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		switch (m_autoSelected) {
			
			case right:
			case leftA:
				LeftA.leftARight();
				break;
			
			case leftB:
				LeftB.leftB();
				break;
				
			case middle:
				Middle.middle();
				break;
				
			case leftASwitch:
				LeftASwitch.leftASwitch();
				break;
				
			case leftBSwitch:
				LeftBSwitch.leftBSwitch();
				break;
				
			case middleSwitch:
				MiddleSwitch.middleSwitch();
				break;
				
			case rightSwitch:
				RightSwitch.rightSwitch();
				break;
				
			case defaultAuto:
			default:
				// Put default auto code here
				break;
		}
	}
	
	/**
	 * This function called once before the teleoperated period.
	 */
	@Override
	public void teleopInit() {
		
		Objects.compressor.start();
		
		arm.setInitArmPos();
		
		catapult.stop();
	}
	
	
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		arm.setArm(1500 , .0175);
		arm.flywheel();
		drive.setPower();
		
		if (Objects.controller.getRawButton(1)) {
			while (Objects.controller.getRawButton(1));
			catapult.fire(.7);
		}
		
		SmartDashboard.putNumber("encoder", drive.getDegrees());
	}
	

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
