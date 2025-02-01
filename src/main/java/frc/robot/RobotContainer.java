package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.AlgaeSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {

    private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
    private final AlgaeSubsystem m_algaeSubsystem = new AlgaeSubsystem();
    private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.k_driverController);

    public RobotContainer() {

        configureBindings();

       m_swerveSubsystem.setDefaultCommand(driveFieldOrientedAngularVelocity);
       m_algaeSubsystem.setDefaultCommand(algaeArmRotation);
    }

    private void configureBindings() {
        //Where you decide what each button does
        new JoystickButton(m_driverController.getHID(), OperatorConstants.k_algaeReleaseArmButton).whileTrue(m_algaeSubsystem.armRotationCommand(-1*OperatorConstants.k_AlgaeArmRotationSpeed));
        new JoystickButton(m_driverController.getHID(), OperatorConstants.k_algaePickupArmButton).whileTrue(m_algaeSubsystem.armRotationCommand(OperatorConstants.k_AlgaeArmRotationSpeed));
        new POVButton(m_driverController.getHID(), OperatorConstants.k_algaeReleaseRollerPOV).whileTrue(m_algaeSubsystem.rollCommand(-1*OperatorConstants.k_AlgaeArmRotationSpeed));
        new POVButton(m_driverController.getHID(), OperatorConstants.k_algaePickupRollerPOV).whileTrue(m_algaeSubsystem.rollCommand(OperatorConstants.k_AlgaeArmRotationSpeed));
    }

    Command driveFieldOrientedAngularVelocity = m_swerveSubsystem.driveCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getLeftX() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> m_driverController.getRightX() * DriveConstants.k_turnRate); 
    Command algaeArmRotation = m_algaeSubsystem.armRotationCommand(OperatorConstants.k_AlgaeArmRotationSpeed); 
}