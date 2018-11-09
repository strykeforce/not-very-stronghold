package frc.team2767.commands.coconut;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.Coconut;

public class CoconutStop extends InstantCommand {
  private final Coconut COCONUT = Robot.COCONUT;

  @Override
  protected void initialize() {
    COCONUT.stop();
    System.out.println("COCONUT forward");
  }

  public CoconutStop() {
    requires(COCONUT);
  }
}
