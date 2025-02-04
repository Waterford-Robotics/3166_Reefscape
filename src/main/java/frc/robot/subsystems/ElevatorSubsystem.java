package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {

    private Talon elevatorMotor1;
    private Talon elevatorMotor2;

    public ElevatorSubsystem() {
        elevatorMotor1 = new Talon(0);
        elevatorMotor2 = new Talon(1);
    }
    public Command elevatorRaiseCommand(double elevatorspeed){ //elevatorspeed is just ElevatorSpinConstants.k_elevatorSpeed but shorter
        return run(() -> {
            elevatorMotor1.set(elevatorspeed);
            elevatorMotor2.set(-elevatorspeed);
        });
    }
    public Command elevatorLowerCommand(double elevatorspeed){
        return run(() -> {
            elevatorMotor1.set(-elevatorspeed);
            elevatorMotor2.set(elevatorspeed);
        });
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}

