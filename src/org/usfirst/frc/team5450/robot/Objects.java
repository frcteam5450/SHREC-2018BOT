package org.usfirst.frc.team5450.robot;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogOutput;
<<<<<<< HEAD
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
=======
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
>>>>>>> 3e0ad1fa6b0a3665e83f845e220f1d60cd159359
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
<<<<<<< HEAD
=======
	
	public static final Compressor compressor = new Compressor();
	
	public static final Compressor compressor = new Compressor();
>>>>>>> 3e0ad1fa6b0a3665e83f845e220f1d60cd159359
	
	public static final Joystick controller = new Joystick(0);
	
	public static final Timer timer = new Timer();
	
	public static final double motorPower = .5;
	
	
	/**
	 * encoder - greyhill 63R256 - 256 counts per rotation
	 */
<<<<<<< HEAD
	public static Encoder driveEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder climbEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
=======
<<<<<<< HEAD
	public static Encoder driveEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
	public static Encoder climbEnc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
=======
	public static final int LSX = 0;
	public static final int LSY = 1;
	public static final int LT = 2;
	public static final int RT = 3;
	public static final int RSX = 4;
	public static final int RSY = 5;		
	
	/**
	 * encoder - greyhill 63R256 - 256 counts per rotation
	 */
	public static Encoder driveEnc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
<<<<<<< HEAD
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
=======
>>>>>>> 310f06a3dd55bcbb49e72cf07e7a898e968c8fdf
>>>>>>> 3e0ad1fa6b0a3665e83f845e220f1d60cd159359
	
}
