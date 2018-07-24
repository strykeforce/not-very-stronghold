package frc.team2767.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.subsystem.Tank;

public class TestTankStop extends InstantCommand {
  private final Tank Tank = new Tank();

  @Override
  protected void initialize() {
    Tank.driveAllPercent(0);
    System.out.println("motors running at 0%");
  }

  public TestTankStop() {
    requires(Tank);
  }
}
