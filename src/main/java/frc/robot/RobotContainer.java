package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.TroughSubsystem;

public class RobotContainer {

    private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
    private final AlgaeSubsystem m_algaeSubsystem = new AlgaeSubsystem();
    private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.k_driverController);
    private final TroughSubsystem m_troughSubsystem = new TroughSubsystem();

    SendableChooser<Command> m_chooser = new SendableChooser<>();

    public RobotContainer() {

        //Autos
        m_chooser.addOption("Test Auto", m_swerveSubsystem.getAutonomousCommand("Test Auto"));

        SmartDashboard.putData("Automode", m_chooser);

        // New EventTrigger("run intake").whileTrue(Commands.print("running intake"));
        // ^ ex. for path planner event triggers

        // new PointTowardsZoneTrigger("Speaker").whileTrue(Commands.print("aiming at speaker"));
        // ^ ex. for path planner point towards zone triggers 



        configureBindings();

       m_swerveSubsystem.setDefaultCommand(driveFieldOrientedAngularVelocity);
    }

    private void configureBindings() {
        //Where you decide what each button does

        //trough
        new JoystickButton(m_driverController.getHID(), 6)
            .whileTrue(new RunCommand(
                () -> m_troughSubsystem.spinCommand(1),
                m_troughSubsystem))
            .onFalse(new RunCommand(
                () -> m_troughSubsystem.stop(),
                m_troughSubsystem));
        
        new JoystickButton(m_driverController.getHID(), 5)
            .whileTrue(new RunCommand(
                () -> m_troughSubsystem.spinCommand(-1),
                m_troughSubsystem))
            .onFalse(new RunCommand(
                () -> m_troughSubsystem.stop(),
                m_troughSubsystem));
    
            // Algae buttons for roller
        new JoystickButton(m_driverController.getHID(), 1)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinRollerCommand(1),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopRoller(),
                m_algaeSubsystem));
        
        new JoystickButton(m_driverController.getHID(), 2)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinRollerCommand(-1),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopRoller(),
                m_algaeSubsystem));
    
        //Algae arm
        new JoystickButton(m_driverController.getHID(), 3)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(0.4),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
        
        new JoystickButton(m_driverController.getHID(), 4)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(-1.5),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
    }

    Command driveFieldOrientedAngularVelocity = m_swerveSubsystem.driveCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getLeftX() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> m_driverController.getRightX() * DriveConstants.k_turnRate); 
    public Command getAutonomousCommand() {

        // The selected auto on SmartDashboard will be run in autonomous
        return m_chooser.getSelected(); 
      }
}