// imports everything from the frc.robot package.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer; // declares the robot container

  /** Called once at the beginning of the robot program, it's a constructor. */
  public Robot() {
  }

  @Override
  public void robotInit() {

    m_robotContainer = new RobotContainer(); // intitalizes the robot container
  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }
  /* Instead of always asking if the button is being pressed, it does it when the robot is being pressed. It can be 
   * used to do things in other places. */

  // This function is run whenever the robot enters disabled mode. 

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This function is run once each time the robot enters autonomous mode. */
  @Override
  public void autonomousInit() {

    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  /** This function is called once each time the robot enters teleoperated mode. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during teleoperated mode. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once each time the robot enters test mode. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
