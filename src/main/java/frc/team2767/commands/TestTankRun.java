package frc.team2767.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.subsystem.Tank;

public class TestTankRun extends InstantCommand {
  private final Tank Tank = new Tank();

  @Override
  protected void initialize() {
    Tank.driveAllPercent(.3);
    System.out.println("Motors running at 30%");
  }

  public TestTankRun() {
    requires(Tank);
  }
}
