package frc.team2767.commands.shooterShoulder;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.ShooterShoulder;

public class ShoulderStop extends InstantCommand {
  private final ShooterShoulder SHOOTER_SHOULDER = Robot.SHOOTER_SHOULDER;

  @Override
  protected void initialize() {
    SHOOTER_SHOULDER.stop();
    System.out.println("Shoulder stop");
  }

  public ShoulderStop() {
    requires(SHOOTER_SHOULDER);
  }
}
