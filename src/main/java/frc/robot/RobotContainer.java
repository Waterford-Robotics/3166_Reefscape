public class RobotContainer {

    private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();

    private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.k_driverController);

    public RobotContainer(){

        configureBindings();

       m_swerveSubsystem.setDefaultCommand(driveFileOrientedAngularVelocity);

    }

    private void configureBindings() {

        //Where you decide what each button does
    }

    Command driveFieldOrientedAngularVelocity = m_swerveSubsystem.driveCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getLeftX() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> m_driverController.getRightX() * DriveConstants.k_turnRate);
    

    

}