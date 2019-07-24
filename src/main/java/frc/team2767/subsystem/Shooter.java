package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.Robot;

public class Shooter extends Subsystem {
  private final int LEFT_ID = 20;
  private final int RIGHT_ID = 21;

  private final TalonSRX left = new TalonSRX(LEFT_ID);
  private final TalonSRX right = new TalonSRX(RIGHT_ID);

  public Shooter() {
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    // TODO: init closed-loop stuff
    left.configAllSettings(config);
    right.configAllSettings(config);

    Robot.TELEMETRY.register(left);
    Robot.TELEMETRY.register(right);
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
