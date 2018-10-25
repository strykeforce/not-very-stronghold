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
public class ShooterShoulder extends Subsystem {
  private final int SHOULDER_ID = 13;
  private final TalonSRX shoulder;

  @Inject
  public ShooterShoulder(Talons talons) {
    shoulder = talons.getTalon(SHOULDER_ID);

    if (shoulder == null) {
      System.out.println("shooter shoulder Talon not found");
    }

    Robot.COMPONENTS
        .telemetryService()
        .register(new TalonItem(shoulder, "shooter Shoulder Talon (13)"));
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
