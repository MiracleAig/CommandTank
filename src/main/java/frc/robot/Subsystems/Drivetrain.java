package frc.robot.Subsystems;

import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotConstants;


// Constucts a new drivetrain object
public class Drivetrain extends SubsystemBase{
    
    CANSparkMax frontLeftMotor;
    CANSparkMax backLeftMotor;
    CANSparkMax frontRightMotor;
    CANSparkMax backRightMotor;

    MotorControllerGroup leftSide;
    MotorControllerGroup rightSide;

    DifferentialDrive differentialDrive;

    public Drivetrain(){
        frontLeftMotor = new CANSparkMax(RobotConstants.DrivetrainConstaints.kLeftFrontID,MotorType.kBrushed);
        backLeftMotor = new CANSparkMax(RobotConstants.DrivetrainConstaints.kLeftBackID, MotorType.kBrushed);

        frontRightMotor = new CANSparkMax(RobotConstants.DrivetrainConstaints.kRightFrontID, MotorType.kBrushed);
        backRightMotor = new CANSparkMax(RobotConstants.DrivetrainConstaints.kRightBackID, MotorType.kBrushed);

        frontRightMotor.setInverted(RobotConstants.DrivetrainConstaints.isRightFrontInverted);
        backRightMotor.setInverted(RobotConstants.DrivetrainConstaints.isRightBackInverted);
        frontLeftMotor.setInverted(RobotConstants.DrivetrainConstaints.isLeftFrontInverted);
        backLeftMotor.setInverted(RobotConstants.DrivetrainConstaints.isLeftBackInverted);

        leftSide = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        rightSide = new MotorControllerGroup(frontRightMotor, backRightMotor);

        differentialDrive = new DifferentialDrive(leftSide, rightSide);
    }

    @Override
    public void periodic() {
        
      // This method will be called once per scheduler run
    }
  
    public void drive(double translation, double rotation){
      if(Math.abs(translation)<RobotConstants.ControllerConstants.kControllerDeadband){
        translation = 0;
      }
  
      if(Math.abs(rotation)<RobotConstants.ControllerConstants.kControllerDeadband){
        rotation = 0;
      }
  
      differentialDrive.arcadeDrive(translation, rotation);
    }

}
