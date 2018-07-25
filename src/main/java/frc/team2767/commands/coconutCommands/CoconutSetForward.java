package frc.team2767.commands.coconutCommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2767.subsystem.Coconut;
import frc.team2767.subsystem.Coconut.CoconutPosition;

public class CoconutSetForward extends Command {
  private final Coconut Coconut = new Coconut();

  @Override
  protected void initialize() {
    Coconut.setPosition(CoconutPosition.FORWARD);
    System.out.println("Coconut set forward");
  }

  @Override
  protected boolean isFinished() {
    return Coconut.positionReached(CoconutPosition.FORWARD);
  }

  @Override
  protected void end() {
    Coconut.stop();
  }

  public CoconutSetForward() {
    requires(Coconut);
  }
}
