package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Objects {
	
	/**
	 * Drive motor declarations
	 */
	public static final WPI_TalonSRX drive0 = new WPI_TalonSRX(0);
	public static final WPI_TalonSRX drive1 = new WPI_TalonSRX(1);
	public static final WPI_TalonSRX drive2 = new WPI_TalonSRX(2);
	public static final WPI_TalonSRX drive3 = new WPI_TalonSRX(3);
	
	/**
	 * Solenoids
	 */
	public static final DoubleSolenoid catapult0 = new DoubleSolenoid(0 , 1);
	public static final DoubleSolenoid catapult1 = new DoubleSolenoid(2 , 3);
	public static final Solenoid driveLeftShift = new Solenoid(4);
	public static final Solenoid driveRightShift = new Solenoid(5);
	
	/**
	 * controller button maps
	 */
	public static final int A = 1;
	public static final int B = 2;
	public static final int X = 3;
	public static final int Y = 4;
	public static final int LB = 5;
	public static final int RB = 6;
	public static final int BACK = 7;
	public static final int START = 8;
	public static final int LSButton = 9;
	public static final int RSButton = 10;
	
	/**
	 * 
	 */
	public static final int LSX = 0;
	public static final int LSY = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	public static final int RSX = 4;
	public static final int RSY = 5;		
}