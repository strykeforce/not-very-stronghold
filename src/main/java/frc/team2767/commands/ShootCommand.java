package frc.team2767.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.team2767.commands.coconut.CoconutSetBack;
import frc.team2767.commands.coconut.CoconutSetForward;
import frc.team2767.commands.shooter.ShooterClosedLoopOn;
import frc.team2767.commands.shooter.ShooterOff;

public class ShootCommand extends CommandGroup {
  public ShootCommand() {
    addSequential(new ShooterClosedLoopOn());
    addSequential(new CoconutSetForward(), 0.5);
    addSequential(new CoconutSetBack());
    addSequential(new ShooterOff());
  }
}
