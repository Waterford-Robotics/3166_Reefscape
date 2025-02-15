package frc.robot;

import com.pathplanner.lib.config.PIDConstants;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController.Button;

public final class Constants {
    
    public static final class SwerveConstants {
        public static final double k_maxSpeed = Units.feetToMeters(18.9); 
    }

    public static final class OperatorConstants {
        public static final int k_driverController = 0;
        public static final double k_AlgaeArmRotationSpeed = 0.1; //all speed variables will have to be adjusted later
        public static final double k_algaeRollerSpeed = 0.1;
        public static final int k_algaeReleaseArmButton = Button.kY.value;
        public static final int k_algaePickupArmButton = Button.kA.value;
        public static final int k_algaePickupRollerPOV = 90; //this dpad POV 90degree
        public static final int k_algaeReleaseRollerPOV = 270; //this is dpad POV 270degree
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.1;
        public static final double k_driveSpeed = -1;
        public static final double k_turnRate = -1;
    }

    public static final class ControllerConstants {
        public static final int troughYforward = 4;
    }

    public static final class TroughSpinConstants {
        public static final double k_troughSpin = -0.8;
    }

    public static final class AutoConstants {
        public static final PIDConstants k_translationPID = new PIDConstants(0.7, 0, 0);
        public static final PIDConstants k_anglePID = new PIDConstants(0.4, 0, 0.01);

        public static final double spinUpAutoTime = 8; 
        public static final double shootAutoTime = 3; 
  }
}