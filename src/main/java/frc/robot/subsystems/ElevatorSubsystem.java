package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorSpinConstants;

public class ElevatorSubsystem extends SubsystemBase {

    private Talon elevatorMotor1;
    private Talon elevatorMotor2;

    public ElevatorSubsystem() {
        elevatorMotor1 = new Talon(0);
        elevatorMotor2 = new Talon(1);
    }
    public Command elevatorRaiseCommand() { 
        return run(() -> {
            elevatorMotor1.set(ElevatorSpinConstants.k_elevatorSpeed);
            elevatorMotor2.set(-ElevatorSpinConstants.k_elevatorSpeed);
        });
    }
    public Command elevatorLowerCommand() {
        return run(() -> {
            elevatorMotor1.set(-ElevatorSpinConstants.k_elevatorSpeed);
            elevatorMotor2.set(ElevatorSpinConstants.k_elevatorSpeed);
        });
    }

    public void stop() {
        elevatorMotor1.set(0);
        elevatorMotor2.set(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}

