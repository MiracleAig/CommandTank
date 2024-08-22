// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Commands.Drive;
import frc.robot.Commands.Intake;
import frc.robot.Commands.Shoot;
import frc.robot.Subsystems.Drivetrain;
import frc.robot.Subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {

public static Drivetrain m_drivetrain = new Drivetrain();
public static Shooter m_shooter = new Shooter();

public static CommandXboxController driverController = new CommandXboxController(RobotConstants.ControllerConstants.kDriverControllerPort);
public static CommandXboxController operatorController = new CommandXboxController(RobotConstants.ControllerConstants.kOperatorControllerPort);

  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  private void configureBindings() {

    m_drivetrain.setDefaultCommand(new Drive(m_drivetrain));

  
    if(RobotConstants.ControllerConstants.kIsOneController){
      driverController.a().whileTrue(new Intake(m_shooter));
      driverController.b().whileTrue(new Shoot(m_shooter));
    }
    else{
      operatorController.a().whileTrue(new Intake(m_shooter));
      operatorController.b().whileTrue(new Shoot(m_shooter));
    }
    
  }

  
}
