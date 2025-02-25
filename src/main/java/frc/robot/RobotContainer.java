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
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_troughRollerForwardButton) //Push coral forward into trough
            .whileTrue(new RunCommand(
                () -> m_troughSubsystem.spinCommand(1),
                m_troughSubsystem))
            .onFalse(new RunCommand(
                () -> m_troughSubsystem.stop(),
                m_troughSubsystem));
        
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_troughRollerBackwardButton) //Push coral backward into robot (can help if one is stuck)
            .whileTrue(new RunCommand(
                () -> m_troughSubsystem.spinCommand(-1),
                m_troughSubsystem))
            .onFalse(new RunCommand(
                () -> m_troughSubsystem.stop(),
                m_troughSubsystem));
    
            //Algae buttons for roller
        new JoystickButton(m_driverController.getHID(),ControllerConstants.k_algaePickupRollerButton) //Run roller inward, pick up algae off floor
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinRollerCommand(1),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopRoller(),
                m_algaeSubsystem));
        
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_algaeReleaseRollerButton) //Push algae out of roller
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinRollerCommand(-1),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopRoller(),
                m_algaeSubsystem));
    
        //Algae arm ---- 3 Buttons on the DPad per command

        //Algae arm down
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmDownPOV1)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(0.4), //Set to 0.4 instead of 1 so the motor will run slower.
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmDownPOV2)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(0.4),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmDownPOV3)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(0.4),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));

                //Algae arm up
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmUpPOV1)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(-1.5), //Set to -1.5 instead of -1 so the motor will run faster, fighting gravity
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmUpPOV2)
            .whileTrue(new RunCommand(
                () -> m_algaeSubsystem.spinShoulderCommand(-1.5),
                m_algaeSubsystem))
            .onFalse(new RunCommand(
                () -> m_algaeSubsystem.stopShoulder(),
                m_algaeSubsystem));
        new POVButton(m_driverController.getHID(), ControllerConstants.k_algaeArmUpPOV3)
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