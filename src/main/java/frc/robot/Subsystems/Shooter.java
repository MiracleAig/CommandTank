// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotConstants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */

  CANSparkMax topRollerMotor;
  CANSparkMax bottomRollerMotor;

  public Shooter() {
    topRollerMotor = new CANSparkMax(RobotConstants.ShooterConstants.kUpperShooterID, MotorType.kBrushed);
    bottomRollerMotor = new CANSparkMax(RobotConstants.ShooterConstants.kLowerShooterID, MotorType.kBrushed);
  }

  public void setSpeed(double speed){
    topRollerMotor.set(-speed);
    bottomRollerMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
