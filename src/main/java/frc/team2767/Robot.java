package frc.team2767;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.control.Controls;
import frc.team2767.subsystem.Tank;
import java.net.URL;

public class Robot extends TimedRobot {
  public static final Tank TANK;
  public static final Controls CONTROLS;
  public static final RobotComponents COMPONENTS;

  static {
    // put Talon configs in thirdcoast.toml
    URL thirdCoastConfig = Robot.class.getResource("/META-INF/thirdcoast.toml");
    COMPONENTS = DaggerRobotComponents.builder().thirdCoastConfig(thirdCoastConfig).build();
    CONTROLS = new Controls();
    TANK = new Tank();
  }

  private Scheduler scheduler;

  @Override
  public void robotInit() {
    System.out.println("Hello!");
    scheduler = Scheduler.getInstance();
    COMPONENTS.telemetryService().start();
  }

  @Override
  public void teleopPeriodic() {
    scheduler.run();
  }
}
