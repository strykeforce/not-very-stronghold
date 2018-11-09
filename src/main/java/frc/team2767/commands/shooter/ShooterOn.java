package frc.team2767.commands.shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.Shooter;

public class ShooterOn extends InstantCommand {
  private final Shooter SHOOTER = Robot.SHOOTER;

  @Override
  protected void initialize() {
    SHOOTER.On();
    System.out.println("Shooter on");
  }

  public ShooterOn() {
    requires(SHOOTER);
  }
}
