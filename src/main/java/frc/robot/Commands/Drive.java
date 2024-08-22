// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotConstants;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.*;

public class Drive extends Command {
  /** Creates a new Drive. */

  Drivetrain drivetrain;
  public Drive(Drivetrain drivetrain) {

    this.drivetrain = drivetrain;
    addRequirements(drivetrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double translationSpeed = RobotContainer.driverController.getLeftY();//
    double rotationSpeed = RobotContainer.driverController.getRightX();//
  
    drivetrain.drive((RobotConstants.DrivetrainConstaints.kTranslationCoefficient) * translationSpeed, 
                      (RobotConstants.DrivetrainConstaints.kRotationCoefficient) * rotationSpeed);

    SmartDashboard.putNumber("Propulsion Speed", translationSpeed);
    SmartDashboard.putNumber("Rotation Speed", rotationSpeed);


  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
