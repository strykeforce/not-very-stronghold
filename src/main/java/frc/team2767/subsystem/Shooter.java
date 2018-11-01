package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.strykeforce.thirdcoast.talon.Talons;

@Singleton
public class Shooter extends Subsystem {
  private final int LEFT_ID = 20;
  private final int RIGHT_ID = 21;

  private final TalonSRX left;
  private final TalonSRX right;

  @Inject
  public Shooter(Talons talons) {
    left = talons.getTalon(LEFT_ID);
    right = talons.getTalon(RIGHT_ID);

    if (left == null || right == null) {
      System.out.println("shooter Talon not found");
    }

    // Robot.COMPONENTS.telemetryService().register(new TalonItem(left, "shooter Left Talon (11)"));
    // Robot.COMPONENTS.telemetryService().register(new TalonItem(right, "shooter Right Talon
    // (12)"));
  }

  @Override
  protected void initDefaultCommand() {}

  public void On() {
    left.set(ControlMode.PercentOutput, .90);
    right.set(ControlMode.PercentOutput, .90);
  }

  public void Off() {
    left.set(ControlMode.PercentOutput, 0);
    right.set(ControlMode.PercentOutput, 0);
  }
}
