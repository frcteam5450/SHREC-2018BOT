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
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
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
<<<<<<< HEAD
	
	/**
	 * Autonomous program selector string variables
	 */
	private static final String defaultAuto = "Default";
	private static final String left = "Left";
	private static final String middle = "Middle";
	private static final String right = "Right";
	
	private String autoPosition;
	
	private static final String defaultAutoAction = "Default";
	private static final String crossLine = "Cross Line";
	private static final String scoreSwitch = "Score Switch";
	private static final String scoreScale = "Score Scale";
	
	private String autoAction;
	/**
	 * SendableChooser declarations, for auto program selector,
	 * and speed selector; removed in final code
	 */
	private SendableChooser<String> autoPositionChooser = new SendableChooser<>();
	private SendableChooser<String> autoActionChooser = new SendableChooser<>();
	
	/**
=======
	
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
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	 * Robot component declarations
	 */
	DriveTrain drive = new DriveTrain(1 , 5 , 1); //DriveTrain declaration
	
<<<<<<< HEAD
	ArmFlywheel arm = new ArmFlywheel(3 , 2); //Arm declaration
	
	Catapult catapult = new Catapult(); //Catapult declartion
	
	Climb climber = new Climb();
	
	Lights lights = new Lights();
	
	Compressor compressor = new Compressor();
	
	CameraServer camera = CameraServer.getInstance();
	
	Timer teleopTimer = new Timer();
	Timer catapultDelay = new Timer();
	boolean catapultFiring = false;
	double time = 0;
=======
	ArmFlywheel arm = new ArmFlywheel(2 , 3); //Arm declaration
	
	Catapult catapult = new Catapult(); //Catapult declartion
	
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	
	
	/**
	 * Variables for various checks and constants.
	 */
	boolean autoCheck;
	double speed;
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
<<<<<<< HEAD
		autoPositionChooser.addDefault("Auto Positions - This is Default Position, Does Nothing", defaultAuto);
		autoPositionChooser.addObject("Left Position - Next to Portal on Left Wall", left);
		autoPositionChooser.addObject("Middle - On Right Side of Exchange", middle);
		autoPositionChooser.addObject("Right - Next to Portal on Right Wall", right);
		
		autoActionChooser.addDefault("Auto Actions - This is Default Action, Does Nothing", defaultAutoAction);
		autoActionChooser.addObject("Cross Auto Line", crossLine);
		autoActionChooser.addObject("Score on Switch", scoreSwitch);
		autoActionChooser.addObject("Score on Scale", scoreScale);
=======
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
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		
		/**
		 * Places auto chooser on SmartDashboard
		 */
<<<<<<< HEAD
		SmartDashboard.putData("Auto choices", autoPositionChooser);
		
		camera.startAutomaticCapture();
=======
		SmartDashboard.putData("Auto choices", m_chooser);
		
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	}

	/**
	 * This function is called once; when autonomous first starts
	 * Is used for autonomous initialization code
	 */
	@Override
	public void autonomousInit() {
<<<<<<< HEAD
		autoPosition = autoPositionChooser.getSelected();
		autoAction = autoActionChooser.getSelected();
		//System.out.println("Auto selected: " + m_autoSelected);
		Objects.compressor.start();
=======
		m_autoSelected = m_chooser.getSelected();
		System.out.println("Auto selected: " + m_autoSelected);
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
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
<<<<<<< HEAD
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
			/**
			 * Checks for selected auto program and runs the  appropriate one
			 */
			switch (autoPosition) {
			
				case left:
					switch (autoAction) {
						case crossLine:
							Left.crossLine();
							break;
							
						case scoreSwitch:
							if (gameData.charAt(0) == 'L')
								Left.switchLeft();
							else
								Left.crossLine();
							break;
							
						case scoreScale:
							if (gameData.charAt(1) == 'L')
								Left.scoreScaleLeft();
							if (gameData.charAt(1) == 'R')
								Left.scoreScaleRight();
							break;
						
						case defaultAutoAction:
						default:
							drive.stopDrive();
					}
					
					break;
					
				case middle:
					switch (autoAction) {
						case crossLine:
							Middle.crossLine();
							break;
							
						case scoreSwitch:
							if (gameData.charAt(0) == 'L')
								Middle.leftSwitch();
							if (gameData.charAt(0) == 'R')
								Middle.rightSwitch();
							break;
							
						case scoreScale:
						case defaultAutoAction:
						default:
							drive.stopDrive();
					}
					
					break;
					
				case right:
					switch (autoAction) {
						case crossLine:
							Right.crossLine();
							break;
							
						case scoreSwitch:
							if (gameData.charAt(0) == 'R')
								Right.switchRight();
							else
								Right.crossLine();
							break;
							
						case scoreScale:
							if (gameData.charAt(1) == 'L')
								Right.scoreScaleLeft();
							if (gameData.charAt(1) == 'R')
								Right.scoreScaleRight();
							break;
							
						case defaultAutoAction:
						default:
							drive.stopDrive();
					}
					
=======
		
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
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
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
<<<<<<< HEAD
		
		/**
		 * Starts compressor
		 */
		compressor.set(true);
		
		/**
		 * Sets initial arm position
		 */
=======
		
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
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		
		drive.stopDrive();
		DriveTrain.gyro.reset();
		DriveTrain.encoder.reset();
<<<<<<< HEAD
		
		teleopTimer.reset();
		teleopTimer.start();
		catapultDelay.start();
=======
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
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
<<<<<<< HEAD
		arm.displayStats();
=======
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		
		/**
		 * Sets drive power based on controller,
		 * and shows output current of motors on the SmartDashboard.
		 */
		drive.setPower(.7);
<<<<<<< HEAD
		drive.displayStats();
		if (drive.gearState && !catapultFiring)
			lights.setLights("highGear");
		else
			if (!catapultFiring)
				lights.setLights("lowGear");
=======
		drive.showCurrent();
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
		
		/**
		 * Fires catapult when 'A' is pressed.
		 */
		if (Objects.controller.getRawButton(1)) {
<<<<<<< HEAD
			catapultFiring = true;
			lights.setLights("catapultFire");
			if (catapultDelay.get() >= .5) {
				catapult.fire();
			}
			else
				if (catapultDelay.get() < 1.1)
					catapult.stop();
		}
		else {
			catapultDelay.reset();
			catapultFiring = false;
		}
		
		if (Objects.controller.getRawButton(9)) {
			while (Objects.controller.getRawButton(9));
			drive.shift();
		}
		/**
		 * Places encoder value on SmartDashboard.
		 */
		SmartDashboard.putBoolean("Compressor Enabled?", Objects.compressor.enabled());
		
		/**
		 * Only allows winch to be operated in the end game
		 */
		double teleopTime = teleopTimer.get();
		if (teleopTime >= 105) {
			if (Objects.controller.getRawButton(3))
				climber.extendArm();
			
			if (Objects.controller.getRawButton(4))
				climber.retractArm();
			
			if (!Objects.controller.getRawButton(3) && !Objects.controller.getRawButton(4))
				climber.stopExtend();
			
			if (Objects.controller.getRawButton(7))
				climber.climb();
			
			if (Objects.controller.getRawButton(8))
				climber.extendClimb();
			
			if (!Objects.controller.getRawButton(7) && !Objects.controller.getRawButton(8))
				climber.stopClimb();
			
			if (Objects.controller.getRawButton(10)) {
				while (Objects.controller.getRawButton(10));
				climber.pistonClimb();
			}
			
			climber.displayStats();
		}
=======
			while (Objects.controller.getRawButton(1)); //Button debounce
			catapult.fire(.7);
		}
		
		/**
		 * Places encoder value on SmartDashboard.
		 */
		SmartDashboard.putNumber("encoder", drive.getDegrees());
		
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
	}
	
}
