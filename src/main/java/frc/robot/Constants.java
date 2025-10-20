package frc.robot;

import com.pathplanner.lib.config.PIDConstants;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.math.util.Units;

public final class Constants {
    
    public static final class SwerveConstants {
        public static final double k_maxSpeed = Units.feetToMeters(18.9); 
    }

    public static final class MotorChannelConstants { // The ports on the RoboRio
        public static final int troughMotorChannel = 1;
        public static final int shoulderMotorChannel = 3;
        public static final int algaerollerMotorChannel = 4;
    }

    
    public static final class OperatorConstants {
        public static final int k_driverController = 0;
        public static final int k_operatorController = 1;
        public static final double k_algaeShoulderRotationSpeed = 0.3; //all speed variables will have to be adjusted later
        public static final double k_algaeRollerSpeed = 0.55;
        public static final double k_troughRollerSpeed = -0.49;
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.1;
        public static final double k_driveSpeed = -0.4;
        public static final double k_turnRate = -1;
        public static final double k_driveMaxSpeed = 0.70;
        public static final double k_strafeMaxSpeed = 0.40;
    }

    public static final class ControllerConstants {
        
        public static final int resetNavX = 8; 
        public static final int k_algaeArmUp = 6;  //Right Bumper
        public static final int k_algaeArmDown = 5; //Left Bumper
        public static final int k_algaeDisplaceButton = 5; // Right Bumper
        public final static int k_righttrig = Axis.kRightTrigger.value; // Right Trig
        public final static int k_lefttrig = Axis.kLeftTrigger.value; // Left Trig
    }

    public static final class AutoConstants {
        public static final PIDConstants k_translationPID = new PIDConstants(0.7, 0, 0);
        public static final PIDConstants k_anglePID = new PIDConstants(0.4, 0, 0.01);

        public static final double spinUpAutoTime = 8; 
        public static final double shootAutoTime = 3; 
        
  }
}