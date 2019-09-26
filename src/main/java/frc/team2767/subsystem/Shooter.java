package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.Robot;

public class Shooter extends Subsystem {
  private final int LEFT_ID = 20;
  private final int RIGHT_ID = 21;
  private final int finalVelocity = 2000;
  private final int closeEnough = 500;

  private final TalonSRX left = new TalonSRX(LEFT_ID);
  private final TalonSRX right = new TalonSRX(RIGHT_ID);

  public Shooter() {
    TalonSRXConfiguration config = new TalonSRXConfiguration();
    // TODO: init closed-loop stuff
    left.configAllSettings(config);
    right.configAllSettings(config);

    Robot.TELEMETRY.register(left);
    Robot.TELEMETRY.register(right);
    configTalon();
  }

  private void configTalon() {
    TalonSRXConfiguration shooterConfig = new TalonSRXConfiguration();
    shooterConfig.slot0.kP = 3;
    shooterConfig.slot0.kI = 0.015;
    shooterConfig.slot0.kD = 300;
    shooterConfig.slot0.kF = 1.6;
    shooterConfig.slot0.integralZone = 25;
    shooterConfig.closedloopRamp = 0.5;
    shooterConfig.openloopRamp = 0.5;
    shooterConfig.peakOutputForward = 1;
    shooterConfig.peakOutputReverse = -1;
    shooterConfig.slot0.allowableClosedloopError = 0;
  }

  @Override
  protected void initDefaultCommand() {}

  public void On() {
    left.set(ControlMode.Velocity, finalVelocity);
    right.set(ControlMode.Velocity, finalVelocity);
  }

  public void Off() {
    left.set(ControlMode.Velocity, 0);
    right.set(ControlMode.Velocity, 0);
  }

  public boolean speedReached() {
    return Math.abs(left.getSelectedSensorVelocity(0) - finalVelocity) < closeEnough;
  }
}
