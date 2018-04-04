package org.usfirst.frc.team5450.robot.RobotCommandFunctions;
 
import org.usfirst.frc.team5450.robot.Objects;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.DriverStation;

import java.lang.Math;
 
public class DriveTrain {
   
    WPI_TalonSRX driveLeft1 = Objects.driveLeft1;
    WPI_TalonSRX driveLeft2 = Objects.driveLeft2;
    WPI_TalonSRX driveRight1 = Objects.driveRight1;
    WPI_TalonSRX driveRight2 = Objects.driveRight2;
   
    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
   
    public static Timer encoder = new Timer();
   
 
   
   
   
    Solenoid shift = Objects.driveShift;
    public boolean gearState = false;
   
    
    public boolean testBool=DriverStation.getInstance().isAutonomous();
 
       
    String gear = "Low";
   
    Joystick joy = Objects.controller;
    Joystick joy2 = Objects.controller2;
    int lControl = 1;
    int rControl = 5;
    int gearShift;
   
    double multiplier = .7;
   
    public DriveTrain(double k , WPI_TalonSRX motor1 , WPI_TalonSRX motor2 , WPI_TalonSRX motor3 , WPI_TalonSRX motor4 , Solenoid lShift , Solenoid rShift) {
        multiplier = k;
        driveLeft1 = motor1;
        driveLeft2 = motor2;
        driveRight1 = motor3;
        driveRight2 = motor4;
        shift.set(false);
       
        Objects.driveEnc.reset();
        Objects.driveEnc.setMaxPeriod(.1);
        Objects.driveEnc.setMinRate(10);
        Objects.driveEnc.setDistancePerPulse(5);
        Objects.driveEnc.setReverseDirection(true);
        Objects.driveEnc.setSamplesToAverage(7);
    }
   
    public DriveTrain(int leftControlAxis , int rightControlAxis , int gear) {
        lControl = leftControlAxis;
        rControl = rightControlAxis;
        gearShift = gear;
    }
   
    public DriveTrain() {
       
    }
   
    public void setPower(double kMultiplier) {
        multiplier = kMultiplier;
       
        double leftPower = (joy.getRawAxis(lControl)) * multiplier;
        double rightPower = (joy.getRawAxis(rControl)) * multiplier;
       
        driveLeft1.set(-leftPower);
        driveLeft2.set(-leftPower);
        driveRight1.set(rightPower);
        driveRight2.set(rightPower);
    }
    
    public void setPowerDualDriver(double kMultiplier) { //Code for drivetrain with multiple drivers UNTESTED!!!
    	double leftPower1 = joy.getRawAxis(lControl) * kMultiplier;
    	double leftPower2 = joy2.getRawAxis(lControl) * kMultiplier;
    	double leftPower;
    	
    	if (Math.abs(leftPower2) > Math.abs(leftPower1))
    		leftPower = leftPower2;
    	else
    		leftPower = leftPower1;
    	
    	double rightPower1 = joy.getRawAxis(rControl) * kMultiplier;
    	double rightPower2 = joy2.getRawAxis(rControl) * kMultiplier;
    	double rightPower;
    	
    	if (Math.abs(rightPower2) > Math.abs(rightPower1))
    		rightPower = rightPower2;
    	else
    		rightPower = rightPower1;
    	
    	driveLeft1.set(-leftPower);
        driveLeft2.set(-leftPower);
        driveRight1.set(rightPower);
        driveRight2.set(rightPower);
    }
   
    public void stopDrive() {
        driveRight2.set(0);
        driveLeft1.set(0);
        driveLeft2.set(0);
        driveRight1.set(0);
    }
   
    public void shift() {
        shift.set(!gearState);
        gearState = !gearState;
    }
   
    //public long getDegrees() {
        //return encoder.get();
    //}
   
    public void driveStraight(double motorPower , double gain , double distance) {
       
        gyro.reset();
        double encoderCount = 230 * distance;
       
        encoder.start();
     

       
        while (testBool && encoder.get() < distance)
        {
        double degree = gyro.getAngle();
        double rightPower = motorPower + (degree * gain);
       
        driveLeft1.set(motorPower);
        driveLeft2.set(motorPower);
        driveRight1.set(-rightPower);
        driveRight2.set(-rightPower);
        SmartDashboard.putNumber("Gyro", degree);
        SmartDashboard.putNumber("Right Power", rightPower);
       
        //updates testBool
        testBool=DriverStation.getInstance().isAutonomous();
        //added a 10 msec delay
        encoder.delay(0.010);
       
        displayStats();
        }
        stopDrive();
    }
   
    public void turn(double motorPower , double degrees) {
        gyro.reset();
        double error = degrees - gyro.getAngle();
       
        while (testBool && error > 5) {
            error = degrees - gyro.getAngle();
            driveLeft1.set(motorPower);
            driveLeft2.set(motorPower);
            driveRight1.set(motorPower);
            driveRight2.set(motorPower);
            //updates testBool
            testBool=DriverStation.getInstance().isAutonomous();
            //added a 10 msec delay
            encoder.delay(0.010);
            displayStats();
        }
       
        while (testBool && error < -5) {
            error = degrees - gyro.getAngle();
            driveLeft1.set(-motorPower);
            driveLeft2.set(-motorPower);
            driveRight1.set(-motorPower);
            driveRight2.set(-motorPower);
            
            //updates testBool
            testBool=DriverStation.getInstance().isAutonomous();
            //added a 10 msec delay
            encoder.delay(0.010);
            
            displayStats();
        }
        stopDrive();
    }
   
    public void displayStats() {
        SmartDashboard.putNumber("Back Left Drive Current", driveLeft1.getOutputCurrent());
        SmartDashboard.putNumber("Front Left Drive Current", driveLeft2.getOutputCurrent());
        SmartDashboard.putNumber("Back Right Drive Current", driveRight1.getOutputCurrent());
        SmartDashboard.putNumber("Front Right Drive Current", driveRight2.getOutputCurrent());
        SmartDashboard.putNumber("gyro", gyro.getAngle());
        SmartDashboard.putNumber("Auto Encoder", Objects.driveEnc.get());
       
        if (gearState)
            gear = "High";
        else
            gear = "Low";
        SmartDashboard.putString("Gear:", gear);
    }
}