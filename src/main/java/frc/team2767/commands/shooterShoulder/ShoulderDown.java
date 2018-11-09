package frc.team2767.commands.shooterShoulder;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.ShooterShoulder;

public class ShoulderDown extends InstantCommand {
  private final ShooterShoulder SHOOTER_SHOULDER = Robot.SHOOTER_SHOULDER;

  @Override
  protected void initialize() {
    SHOOTER_SHOULDER.openLoopDown();
    System.out.println("Shoulder down");
  }

  public ShoulderDown() {
    requires(SHOOTER_SHOULDER);
  }
}
