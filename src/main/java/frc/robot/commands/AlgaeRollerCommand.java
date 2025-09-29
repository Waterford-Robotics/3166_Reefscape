package frc.robot.commands;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AlgaeSubsystem;


public class AlgaeRollerCommand extends Command{
   // Uses Subsystems
 AlgaeSubsystem m_algaeSubsystem;
 double m_seconds;
 Timer m_timer = new Timer();


 // Constructor
 public AlgaeRollerCommand(AlgaeSubsystem algaeSubsystem, double seconds) {
      
   // Definitions and setting parameters are equal to members!
   m_algaeSubsystem = algaeSubsystem;
   addRequirements(algaeSubsystem);


   //
   m_seconds = seconds;


 }


 // Reset timer when the command starts executing
 public void initialize() {
   m_timer.start();
   m_timer.reset();
 }
  // Actual command
 public void execute() {


   if(m_timer.get() < m_seconds) {
     m_algaeSubsystem.spinRollerCommand(1);
   }
 }


 // Stuff that happens when command is over
 public void end(boolean interrupted) {
   m_algaeSubsystem.stopRoller();
 }


 // Checks if the command is done
 public boolean isFinished() {


   // Am I done?  Am I done? Am I finally done?
   return m_timer.get() > m_seconds;
 }
}



