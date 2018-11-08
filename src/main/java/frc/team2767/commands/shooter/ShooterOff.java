package frc.team2767.commands.shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.Shooter;

public class ShooterOff extends InstantCommand {
  private final Shooter SHOOTER = Robot.COMPONENTS.shooterSubsystem();

  @Override
  protected void initialize() {
    SHOOTER.Off();
    System.out.println("Shooter on");
  }

  public ShooterOff() {
    requires(SHOOTER);
  }
}
