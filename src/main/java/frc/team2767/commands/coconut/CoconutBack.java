package frc.team2767.commands.coconut;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.Coconut;

public class CoconutBack extends InstantCommand {
  private final Coconut COCONUT = Robot.COMPONENTS.coconutSubsystem();

  @Override
  protected void initialize() {
    COCONUT.openLoopBack();
    System.out.println("COCONUT forward");
  }

  public CoconutBack() {
    requires(COCONUT);
  }
}
