package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.OperatorConstants;

public class AlgaeSubsystem extends SubsystemBase {


    private Talon ShoulderMotor;
    private Talon RollerMotor;

    public AlgaeSubsystem() {
        
        ShoulderMotor = new Talon(3);
        RollerMotor = new Talon(4);
    }
    public Command armPickupCommand() {
        return run(() -> {
            ShoulderMotor.set(OperatorConstants.k_AlgaeArmRotationSpeed);
        });
    }
    public Command armReleaseCommand() {
        return run(() -> {
            ShoulderMotor.set(-1*OperatorConstants.k_AlgaeArmRotationSpeed);
        });
    }
    public Command rollPickupCommand() {
        return run(() -> {
            RollerMotor.set(OperatorConstants.k_algaeRollerSpeed);
        });
    }
    public Command rollReleaseCommand() {
        return run(() -> {
            RollerMotor.set(-1*OperatorConstants.k_algaeRollerSpeed);
        });
    }

    public void stopArm() {
        ShoulderMotor.set(0);
    }

    public void stopRoller() {
        RollerMotor.set(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
 
