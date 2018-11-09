package frc.team2767.commands.coconut;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2767.Robot;
import frc.team2767.subsystem.Coconut;
import frc.team2767.subsystem.Coconut.CoconutPosition;

public class CoconutSetBack extends Command {
  private final Coconut COCONUT = Robot.COCONUT;

  @Override
  protected void initialize() {
    COCONUT.setPosition(CoconutPosition.BACK);
    System.out.println("COCONUT set forward");
  }

  @Override
  protected boolean isFinished() {
    return COCONUT.positionReached(CoconutPosition.BACK);
  }

  public CoconutSetBack() {
    requires(COCONUT);
  }
}
