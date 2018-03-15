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
	 * Robot component declarations
	 */
	DriveTrain drive = new DriveTrain(1 , 5 , 1); //DriveTrain declaration
	
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
		autoPositionChooser.addDefault("Auto Positions - This is Default Position, Does Nothing", defaultAuto);
		autoPositionChooser.addObject("Left Position - Next to Portal on Left Wall", left);
		autoPositionChooser.addObject("Middle - On Right Side of Exchange", middle);
		autoPositionChooser.addObject("Right - Next to Portal on Right Wall", right);
		
		autoActionChooser.addDefault("Auto Actions - This is Default Action, Does Nothing", defaultAutoAction);
		autoActionChooser.addObject("Cross Auto Line", crossLine);
		autoActionChooser.addObject("Score on Switch", scoreSwitch);
		autoActionChooser.addObject("Score on Scale", scoreScale);
		
		/**
		 * Places auto chooser on SmartDashboard
		 */
		SmartDashboard.putData("Auto choices", autoPositionChooser);
		
		camera.startAutomaticCapture();
	}

	/**
	 * This function is called once; when autonomous first starts
	 * Is used for autonomous initialization code
	 */
	@Override
	public void autonomousInit() {
		autoPosition = autoPositionChooser.getSelected();
		autoAction = autoActionChooser.getSelected();
		//System.out.println("Auto selected: " + m_autoSelected);
		Objects.compressor.start();
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
		compressor.set(true);
		
		/**
		 * Sets initial arm position
		 */
		
		drive.stopDrive();
		DriveTrain.gyro.reset();
		DriveTrain.encoder.reset();
		
		teleopTimer.reset();
		teleopTimer.start();
		catapultDelay.start();
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
		arm.displayStats();
		
		/**
		 * Sets drive power based on controller,
		 * and shows output current of motors on the SmartDashboard.
		 */
		drive.setPower(.7);
		drive.displayStats();
		if (drive.gearState && !catapultFiring)
			lights.setLights("highGear");
		else
			if (!catapultFiring)
				lights.setLights("lowGear");
		
		/**
		 * Fires catapult when 'A' is pressed.
		 */
		if (Objects.controller.getRawButton(1)) {
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
	}
	
}
