package frc.robot;

import com.pathplanner.lib.config.PIDConstants;

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
        public static final double k_algaeShoulderRotationSpeed = 0.2; //all speed variables will have to be adjusted later
        public static final double k_algaeRollerSpeed = 0.5;
        public static final double k_troughRollerSpeed = -0.8;
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.1;
        public static final double k_driveSpeed = -1;
        public static final double k_turnRate = -1;
    }

    public static final class ControllerConstants {
        public static final int k_algaeArmUpPOV1 = 315;
        public static final int k_algaeArmUpPOV2 = 0;  //All of these buttons are very close together and you may accidentally press one instead of the other so they all do the same thing
        public static final int k_algaeArmUpPOV3 = 45;
        public static final int k_algaeArmDownPOV1 = 135;
        public static final int k_algaeArmDownPOV2 = 180;  //Same with these 3
        public static final int k_algaeArmDownPOV3 = 225;
        public static final int k_algaePickupRollerButton = 3; // X button (left)
        public static final int k_algaeReleaseRollerButton = 2; // B button (right)
        public static final int k_troughRollerForwardButton = 6; //Right bumper
        public static final int k_troughRollerBackwardButton = 5; //Left bumper
    }

    public static final class AutoConstants {
        public static final PIDConstants k_translationPID = new PIDConstants(0.7, 0, 0);
        public static final PIDConstants k_anglePID = new PIDConstants(0.4, 0, 0.01);

        public static final double spinUpAutoTime = 8; 
        public static final double shootAutoTime = 3; 
        
  }
}