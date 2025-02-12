package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController.Axis;

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
        public final static int k_righttrig = Axis.kRightTrigger.value; // Right Trigger
        public final static int k_lefttrig = Axis.kLeftTrigger.value; // Left Trigger 
    }

    public static final class DriveConstants {
        public static final double k_driveDeadBand = 0.05;
        public static final double k_driveSpeed = -1;
        public static final double k_turnRate = -1;
    }

    public static final class ControllerConstants {
        public static final int troughForward = 6; // Right Bumper
        public static final int troughBackward = 5; // Left Bumper
        public static final int elevatorUp = 3;
        public static final int elevatorDown = 2;
    }

    public static final class TroughSpinConstants {
        public static final double k_troughSpin = 0.8;
    }

    public static final class ElevatorSpinConstants {
        public static final double k_elevatorSpeed = 0.8;
    }
}