package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ElevatorSpinConstants;
import frc.robot.Constants.ChannelConstants;

public class ElevatorSubsystem extends SubsystemBase {

    private Talon elevatorMotor1;
    private Talon elevatorMotor2;

    public ElevatorSubsystem() {
        elevatorMotor1 = new Talon(ChannelConstants.elevatorMotor1Channel);
        elevatorMotor2 = new Talon(ChannelConstants.elevatorMotor2Channel);
    }

    public void elevatorRaiseCommand() { 
        elevatorMotor1.set(ElevatorSpinConstants.k_elevatorSpeed);
        elevatorMotor2.set(-ElevatorSpinConstants.k_elevatorSpeed);
    }

    public void elevatorLowerCommand() {
        elevatorMotor1.set(-ElevatorSpinConstants.k_elevatorSpeed);
        elevatorMotor2.set(ElevatorSpinConstants.k_elevatorSpeed);
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

