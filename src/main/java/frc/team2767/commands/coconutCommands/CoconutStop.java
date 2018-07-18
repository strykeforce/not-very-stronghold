package frc.team2767.commands.coconutCommands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.subsystem.Coconut;

public class CoconutStop extends InstantCommand {
  private final Coconut Coconut = new Coconut();

  @Override
  protected void initialize() {
    Coconut.stop();
    System.out.println("Coconut forward");
  }

  public CoconutStop() {
    requires(Coconut);
  }
}
