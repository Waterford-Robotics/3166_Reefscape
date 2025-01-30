package frc.robot;

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
        public static final int k_algaePickupRollerButton = 90; //this is going to be dpad POV 90degree
        public static final int k_algaeReleaseRollerButton = 270; //this is going to be dpad POV 270degree
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.05;
        public static final double k_driveSpeed = -1;
        public static final double k_turnRate = -1;
    }
}
