package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AlgaeSubsytem extends SubsystemBase {


    private Talon AlgaeMotor1;
    private Talon AlgaeMotor2;

    public AlgaeSubsytem() {
        
        AlgaeMotor1 = new Talon(0);
        AlgaeMotor2 = new Talon(1);
    }
    public Command spinCommand(double speed){
        return run(() -> {

        });
    }
}
 
