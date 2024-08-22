package frc.robot;

public final class RobotConstants {
   
    public static class ControllerConstants{
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
        
        public static final boolean kIsOneController = true;

        public static final double kControllerDeadband = 0.04;
    }

    public static class DrivetrainConstaints{
        public static final int kRightBackID = 1;
        public static final int kRightFrontID = 2;

        public static final int kLeftBackID  = 3;
        public static final int kLeftFrontID = 4;

        public static final boolean isRightBackInverted = true;
        public static final boolean isRightFrontInverted = true;
        public static final boolean isLeftBackInverted = false;
        public static final boolean isLeftFrontInverted = false;

        public static final double kTranslationCoefficient  = 1.0;
        public static final double kRotationCoefficient = 1.0;
    }

    public static class ShooterConstants{
        public static final int kUpperShooterID = 6;
        public static final int kLowerShooterID = 7;

        public static final double kIntakeSpeed = 0.3;

        public static final double kShootSpeed = 1.0;
    }

}
