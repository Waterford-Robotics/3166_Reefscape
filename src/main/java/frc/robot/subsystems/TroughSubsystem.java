package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.TroughSpinConstants.k_troughSpin;

public class TroughSubsystem extends SubsystemBase
{
    private Talon troughMotor;

    public TroughSubsystem() {
        troughMotor = new Talon(0);
    }

    public void spinCommand() {
        troughMotor.set(k_troughSpin); 
    }

    public void stop() {
        troughMotor.set(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
