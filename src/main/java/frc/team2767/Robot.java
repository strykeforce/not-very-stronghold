package frc.team2767;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.control.Controls;
import frc.team2767.subsystem.Tank;

public class Robot extends TimedRobot {
  private Scheduler scheduler;
  public static final Tank TANK = new Tank();
  public static final Controls CONTROLS = new Controls();

  @Override
  public void robotInit() {
    System.out.println("Hello!");
    scheduler = Scheduler.getInstance();
  }

  @Override
  public void teleopPeriodic() {
    scheduler.run();
  }
}
