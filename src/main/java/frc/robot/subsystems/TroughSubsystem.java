package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorChannelConstants;

import static frc.robot.Constants.OperatorConstants.k_troughRollerSpeed;

public class TroughSubsystem extends SubsystemBase
{
    private Talon troughMotor;

    public TroughSubsystem() {
        troughMotor = new Talon(MotorChannelConstants.troughMotorChannel);
    }

    public void spinCommand(int polarity) {
        troughMotor.set(polarity*k_troughRollerSpeed);
    }

    public void stop() {
        troughMotor.set(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
