package frc.robot.subsystem;

import java.io.File;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import swervelib.SwerveDrive;

public class SwerveSubsystem extends SubsystemBase {

    // Imports stuff from the JSON files
    File directory = new File(Filesystem.getDeployDirectory(),"swerve");
        SwerveDrive swerveDrive;
    
        public SwerveSubsystem() {
            
        }
        
    
}
    

