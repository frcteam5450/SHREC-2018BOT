/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

/**
 * Version 0.0.1
 * @author FRC Team 5450 SHREC
 * 
 * Main Robot Code, work in progress.
 * 
 */

package org.usfirst.frc.team5450.robot;

/**
 * Imports necessary wpi libraries
 */
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Imports necessary custom robot classes
 */
import org.usfirst.frc.team5450.robot.Objects;
import org.usfirst.frc.team5450.robot.RobotCommandFunctions.*;

/**
 * Imports necessary robot autonomous classes
 */
import org.usfirst.frc.team5450.robot.Autonomous.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */


public class Robot extends IterativeRobot {
	
	/**
	 * Autonomous program selector string variables
	 */
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
	
	
	/**
	 * SendableChooser declarations, for auto program selector,
	 * and speed selector; removed in final code
	 */
	private SendableChooser<String> m_chooser = new SendableChooser<>();
	
	/**
	 * Robot component declarations
	 */
	DriveTrain drive = new DriveTrain(1 , 5 , 1); //DriveTrain declaration
	
	ArmFlywheel arm = new ArmFlywheel(2 , 3); //Arm declaration
	
	Catapult catapult = new Catapult(); //Catapult declartion
	
	
	/**
	 * Variables for various checks and constants.
	 */
	boolean autoCheck;
	double speed;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		/**
		 * Adds programs to auto program chooser
		 */
		//cross line and default programs
		m_chooser.addDefault("Default Auto - Does Nothing", defaultAuto);
		m_chooser.addObject("Left A - Drives Forward", leftA);
		m_chooser.addObject("Left B - Turns Left, Drives Forward", leftB);
		m_chooser.addObject("Middle - Turns Right, Drives Forward", middle);
		m_chooser.addObject("Right - Drives Forward", right);
		
		//Switch placing programs
		m_chooser.addObject("Left A Switch - Places Cube in Switch", leftASwitch);
		m_chooser.addObject("Left B Switch - Places Cube in Switch", leftBSwitch);
		m_chooser.addObject("Middle Switch - Places Cube in Switch", middleSwitch);
		m_chooser.addObject("Right Switch - Places Cube in Switch", rightSwitch);
		
		/**
		 * Places auto chooser on SmartDashboard
		 */
		SmartDashboard.putData("Auto choices", m_chooser);
		
	}

	/**
	 * This function is called once; when autonomous first starts
	 * Is used for autonomous initialization code
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		System.out.println("Auto selected: " + m_autoSelected);
		/**
		 * Initializes autoCheck to true when autonomous is first started
		 */
		autoCheck = true;
	}

	/**
	 * This function is called periodically during autonomous.
	 */ 
	@Override
	
	public void autonomousPeriodic() {
		
		/**
		 * Checks to make sure autonomous has not already run
		 */
		if (autoCheck) {
		
			/**
			 * Checks for selected auto program and runs the  appropriate one
			 */
			switch (m_autoSelected) {
			
				case right:
				case leftA:
					LeftA.leftARight();
					autoCheck = false;
					break;
			
				case leftB:
					LeftB.leftB();
					autoCheck = false;
					break;
				
				case middle:
					Middle.middle();
					autoCheck = false;
					break;
					
				case leftASwitch:
					LeftASwitch.leftASwitch();
					autoCheck = false;
					break;
					
				case leftBSwitch:
					LeftBSwitch.leftBSwitch();
					autoCheck = false;
					break;
					
				case middleSwitch:
					MiddleSwitch.middleSwitch();
					autoCheck = false;
					break;
					
				case rightSwitch:
					RightSwitch.rightSwitch();
					autoCheck = false;
					break;
				
				/**
				 * Default auto program, does nothing for safety purposes
				 */
				case defaultAuto:
				default:
					drive.stopDrive();
					break;
			}
		}
	} 
	
	/**
	 * This function called once before the teleoperated period.
	 */
	@Override
	public void teleopInit() {
		
		/**
		 * Starts compressor
		 */
		Objects.compressor.start();
		
		/**
		 * Sets initial arm position
		 */
		arm.setInitArmPos();
		
		/**
		 * Sets initial catapult state (off)
		 */
		catapult.stop();
		
		drive.stopDrive();
		DriveTrain.gyro.reset();
		DriveTrain.encoder.reset();
	}
	
	
	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		
		/**
		 * Sets arm pivot and flywheel power based on controller input
		 */
		arm.setArm(1500 , .0175);
		arm.flywheel();
		
		/**
		 * Sets drive power based on controller,
		 * and shows output current of motors on the SmartDashboard.
		 */
		drive.setPower(.7);
		drive.showCurrent();
		
		/**
		 * Fires catapult when 'A' is pressed.
		 */
		if (Objects.controller.getRawButton(1)) {
			while (Objects.controller.getRawButton(1)); //Button debounce
			catapult.fire(.7);
		}
		
		/**
		 * Places encoder value on SmartDashboard.
		 */
		SmartDashboard.putNumber("encoder", drive.getDegrees());
		
	}
	
}
