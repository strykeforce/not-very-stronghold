package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.Robot;

public class ShooterShoulder extends Subsystem {
  private final int SHOULDER_ID = 30;
  private final TalonSRX shoulder = new TalonSRX(SHOULDER_ID);

  public ShooterShoulder() {
    Robot.TELEMETRY.register(shoulder);
  }

  @Override
  protected void initDefaultCommand() {}

  public void openLoopUp() {
    shoulder.set(ControlMode.PercentOutput, .20);
    System.out.println("Shoulder encoder: " + shoulder.getSelectedSensorPosition(0));
  }

  public void openLoopDown() {
    shoulder.set(ControlMode.PercentOutput, -.20);
    System.out.println("Shoulder encoder: " + shoulder.getSelectedSensorPosition(0));
  }

  public void stop() {
    shoulder.set(ControlMode.PercentOutput, 0);
    System.out.println("Shoulder encoder: " + shoulder.getSelectedSensorPosition(0));
  }
}
