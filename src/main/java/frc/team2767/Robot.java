package frc.team2767;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.control.Controls;

public class Robot extends TimedRobot {
  private Scheduler scheduler;

  @Override
  public void robotInit() {
    System.out.println("Hello!");
    scheduler = Scheduler.getInstance();
    new Controls();
  }

  @Override
  public void teleopPeriodic() {
    scheduler.run();
  }
}
