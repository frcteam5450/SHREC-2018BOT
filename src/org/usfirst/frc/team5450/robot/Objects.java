package org.usfirst.frc.team5450.robot;

import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Objects {
	
	/**
	 * Drive motor declarations
	 */
	public static final WPI_TalonSRX driveLeft1 = new WPI_TalonSRX(4);
	public static final WPI_TalonSRX driveLeft2 = new WPI_TalonSRX(5);
	public static final WPI_TalonSRX driveRight1 = new WPI_TalonSRX(6);
	public static final WPI_TalonSRX driveRight2 = new WPI_TalonSRX(7);
	public static final WPI_TalonSRX flywheelRight = new WPI_TalonSRX(3);
	public static final WPI_TalonSRX flywheelLeft = new WPI_TalonSRX(2);
	public static final WPI_TalonSRX armPivot = new WPI_TalonSRX(8);
	public static final WPI_TalonSRX extenderWinch = new WPI_TalonSRX(0);
	public static final WPI_TalonSRX climbingWinch = new WPI_TalonSRX(1);
	
	/**
	 * Solenoids
	 */
	public static final DoubleSolenoid catapult0 = new DoubleSolenoid(0 , 1);
	public static final DoubleSolenoid catapult1 = new DoubleSolenoid(2 , 3);
	public static final Solenoid driveShift = new Solenoid(4);
	public static final Solenoid climbPiston = new Solenoid(5);
	
	public static final Compressor compressor = new Compressor();
	public static final Relay compRelay = new Relay(0);
	
	public static final Joystick controller = new Joystick(0);
	
	public static final Timer timer = new Timer();
	
	public static final double motorPower = .5;
	
	
	/**
	 * encoder - greyhill 63R256 - 256 counts per rotation
	 */
	public static Encoder driveEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder climbEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	
}
