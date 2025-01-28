package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TroughSubsystem extends SubsystemBase
{
    private Talon troughMotor;

    public TroughSubsystem()
    {
        troughMotor = new Talon(0);
    }

    public Command spinCommand(double spinDirection)
    {
        return run(() -> 
        {
            troughMotor.set(spinDirection);
        });
    }
   
   
   
    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
