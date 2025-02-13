package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.OperatorConstants.k_AlgaeArmRotationSpeed;

public class AlgaeSubsystem extends SubsystemBase {


    private Talon ShoulderMotor;
    private Talon RollerMotor;

    public AlgaeSubsystem() {
        
        ShoulderMotor = new Talon(3);
        RollerMotor = new Talon(4);
    }
    public Command armPickupCommand() {
        return run(() -> {
            ShoulderMotor.set(k_AlgaeArmRotationSpeed);
        });
    }
    public Command armReleaseCommand() {
        return run(() -> {
            ShoulderMotor.set(-1*k_AlgaeArmRotationSpeed);
        });
    }
    public Command rollPickupCommand() {
        return run(() -> {
            RollerMotor.set(k_AlgaeArmRotationSpeed);
        });
    }
    public Command rollReleaseCommand() {
        return run(() -> {
            RollerMotor.set(-1*k_AlgaeArmRotationSpeed);
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
 