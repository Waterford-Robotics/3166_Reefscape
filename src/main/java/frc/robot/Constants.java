package frc.robot;

import edu.wpi.first.math.util.Units;

public final class Constants {
    
    public static final class SwerveConstants {
        public static final double k_maxSpeed = Units.feetToMeters(18.9);
    }

    public static final class OperatorConstants {
        public static final int k_driverController = 0;
        public static final double k_AlgaeArmRotationSpeed = 0.1;
        public static final int k_algaeReleaseArmRotation = 0;
        public static final int k_algaePickupArmRotation = 180;
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.05;
        public static final double k_driveSpeed = -1;
        public static final double k_turnRate = -1;
    }
}
