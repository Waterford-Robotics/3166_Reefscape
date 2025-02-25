package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorChannelConstants;

import static frc.robot.Constants.OperatorConstants.k_algaeRollerSpeed;
import static frc.robot.Constants.OperatorConstants.k_algaeShoulderRotationSpeed;

public class AlgaeSubsystem extends SubsystemBase {


    private Talon shoulderMotor;
    private Talon rollerMotor;

    public AlgaeSubsystem() {
        shoulderMotor = new Talon(MotorChannelConstants.shoulderMotorChannel);
        rollerMotor = new Talon(MotorChannelConstants.algaerollerMotorChannel);
    }
   
    public void spinRollerCommand(double polarity) {
        rollerMotor.set(polarity*k_algaeRollerSpeed);
       
    }
    public void spinShoulderCommand(double polarity) {
        shoulderMotor.set(polarity*k_algaeShoulderRotationSpeed);
        
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
 
