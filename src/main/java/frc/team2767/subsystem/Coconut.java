package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.Robot;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.strykeforce.thirdcoast.talon.Talons;
import org.strykeforce.thirdcoast.telemetry.item.TalonItem;

@Singleton
public class Coconut extends Subsystem {
  private final int COCONUT_ID = 40;
  private final int feedPostition = 75000;
  private final int backPostition = 10000;
  private final int closeEnough = 3000;
  private final TalonSRX coconut;

  @Inject
  public Coconut(Talons talons) {
    coconut = talons.getTalon(COCONUT_ID);

    if (coconut == null) {
      System.out.println("Coconut Talon not found");
    }

    Robot.COMPONENTS.telemetryService().register(new TalonItem(coconut, "Coconut Talon (40)"));
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

  public enum CoconutPosition {
    FORWARD,
    BACK;
  }
}
