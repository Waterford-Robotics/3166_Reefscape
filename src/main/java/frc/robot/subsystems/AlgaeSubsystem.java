package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.OperatorConstants.k_algaeRollerSpeed;
import static frc.robot.Constants.OperatorConstants.k_algaeArmRotationSpeed;

public class AlgaeSubsystem extends SubsystemBase {


    private Talon shoulderMotor;
    private Talon rollerMotor;

    public AlgaeSubsystem() {
        shoulderMotor = new Talon(3);
        rollerMotor = new Talon(4);
    }
   
    public void spinRollerCommand(double polarity) {
        rollerMotor.set(polarity*k_algaeRollerSpeed);
       
    }
    public void spinShoulderCommand(double polarity) {
        shoulderMotor.set(polarity*k_algaeArmRotationSpeed);
        
    }
    public void stopShoulder() {
        shoulderMotor.set(0);
    }
    public void stopRoller() {
        rollerMotor.set(0);
    }

    @Override
    public void periodic() {}

    @Override
    public void simulationPeriodic() {}
}
 
