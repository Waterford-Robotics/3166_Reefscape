package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AlgaeSubsystem extends SubsystemBase {


    private Talon ShoulderMotor;
    private Talon RollerMotor;

    public AlgaeSubsystem() {
        
        ShoulderMotor = new Talon(3);
        RollerMotor = new Talon(4);
    }
    public Command armRotationCommand(double shoulderspeed) {
        return run(() -> {
            ShoulderMotor.set(shoulderspeed);
        });
    }
    public Command rollCommand(double rollerspeed) {
        return run(() -> {
            RollerMotor.set(rollerspeed);
        });
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
 
