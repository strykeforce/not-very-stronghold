package frc.team2767.commands.shooterShoulder;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.team2767.Robot;
import frc.team2767.subsystem.ShooterShoulder;

public class ShoulderUp extends InstantCommand {
  private final ShooterShoulder SHOOTER_SHOULDER = Robot.COMPONENTS.shooterShoulderSubsystem();

  @Override
  protected void initialize() {
    SHOOTER_SHOULDER.openLoopUp();
    System.out.println("Shoulder up");
  }

  public ShoulderUp() {
    requires(SHOOTER_SHOULDER);
  }
}
