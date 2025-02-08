package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import frc.robot.subsystems.TroughSubsystem;

public class RobotContainer {

    private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
    private final AlgaeSubsystem m_algaeSubsystem = new AlgaeSubsystem();
    private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.k_driverController);
    private final TroughSubsystem m_troughSubsystem = new TroughSubsystem();
    private final ElevatorSubsystem m_elevatorSubsystem = new ElevatorSubsystem();

    public RobotContainer() {

        configureBindings();

       m_swerveSubsystem.setDefaultCommand(driveFieldOrientedAngularVelocity);
    }

    private void configureBindings() {
        //Where you decide what each button does


        //Algae//
        new JoystickButton(m_driverController.getHID(), OperatorConstants.k_algaePickupArmButton)
        .whileTrue(m_algaeSubsystem.startEnd(m_algaeSubsystem::armPickupCommand, m_algaeSubsystem::stopArm));

        new JoystickButton(m_driverController.getHID(), OperatorConstants.k_algaeReleaseArmButton)
            .whileTrue(m_algaeSubsystem.startEnd(m_algaeSubsystem::armReleaseCommand, m_algaeSubsystem::stopArm));

        new POVButton(m_driverController.getHID(), OperatorConstants.k_algaePickupRollerPOV)
        .whileTrue(m_algaeSubsystem.startEnd(m_algaeSubsystem::rollPickupCommand, m_algaeSubsystem::stopRoller));
        
        new POVButton(m_driverController.getHID(), OperatorConstants.k_algaeReleaseRollerPOV)
        .whileTrue(m_algaeSubsystem.startEnd(m_algaeSubsystem::rollReleaseCommand, m_algaeSubsystem::stopRoller));


        //Trough//
        new JoystickButton(m_driverController.getHID(), ControllerConstants.troughForward)
            .whileTrue(m_troughSubsystem.startEnd(m_troughSubsystem::spinCommand, m_troughSubsystem::stop));
            // FINISH THIS 


        //Elevator//
        new Trigger(() -> m_driverController.getRawAxis(OperatorConstants.k_righttrig) > 0.05)
            .whileTrue(
        new InstantCommand(() -> m_elevatorSubsystem.elevatorRaiseCommand(), m_elevatorSubsystem))
            .whileFalse(
        new InstantCommand(() -> m_elevatorSubsystem.stop(), m_elevatorSubsystem)
        );    

        new Trigger(() -> m_driverController.getRawAxis(OperatorConstants.k_lefttrig) > 0.05)
            .whileTrue(
        new InstantCommand(() -> m_elevatorSubsystem.elevatorLowerCommand(), m_elevatorSubsystem))
            .whileFalse(
        new InstantCommand(() -> m_elevatorSubsystem.stop(), m_elevatorSubsystem)
        );    
    }

    Command driveFieldOrientedAngularVelocity = m_swerveSubsystem.driveCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getLeftX() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> m_driverController.getRightX() * DriveConstants.k_turnRate); 
}
