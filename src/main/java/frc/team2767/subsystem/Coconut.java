package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Coconut extends Subsystem {
  private final int COCONUT = 40;

  public enum CoconutPosition {
    FORWARD,
    BACK;
  }

  private final int feedPostition = 75000;
  private final int backPostition = 0;
  private final int closeEnough = 3000;

  private final TalonSRX coconut;

  public Coconut() {
    coconut = new TalonSRX(COCONUT);

    if (coconut == null) {
      System.out.println("Coconut not found");
    }
  }

  @Override
  protected void initDefaultCommand() {}

  public void openLoopForward() {
    coconut.set(ControlMode.PercentOutput, .20);
    System.out.println(coconut.getSelectedSensorPosition(0));
  }

  public void openLoopBack() {
    coconut.set(ControlMode.PercentOutput, -.20);
    System.out.println(coconut.getSelectedSensorPosition(0));
  }

  public void stop() {
    coconut.set(ControlMode.PercentOutput, 0);
    System.out.println("Coconut encoder: " + coconut.getSelectedSensorPosition(0));
  }

  public void setPosition(CoconutPosition position) {
    if (position == CoconutPosition.FORWARD) {
      coconut.set(ControlMode.PercentOutput, .30);
    } else {
      coconut.set(ControlMode.PercentOutput, -.30);
    }
  }

  public boolean positionReached(CoconutPosition position) {
    if (position == CoconutPosition.FORWARD) {
      return Math.abs(coconut.getSelectedSensorPosition(0) - feedPostition) < closeEnough;
    } else {
      return Math.abs(coconut.getSelectedSensorPosition(0) - backPostition) < closeEnough;
    }
  }
}
