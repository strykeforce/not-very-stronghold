package frc.team2767.control;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team2767.commands.TestTankRun;
import frc.team2767.commands.TestTankStop;

public class Controls {

  private Joystick driveJoystick;
  private JoystickButton rightSwitch;

  private static final int USB = 1;

  public Controls() {

    System.out.println("Controls are constructed");

    if (DriverStation.getInstance().getJoystickName(USB).isEmpty()) {
      System.out.println("missing joystick");
    }

    driveJoystick = new Joystick(USB);
    rightSwitch = new JoystickButton(driveJoystick, 2);

    rightSwitch.whenPressed(new TestTankRun());
    rightSwitch.whenReleased(new TestTankStop());
  }

  public double getRightAxis() {
    return driveJoystick.getRawAxis(Axis.X_AXIS.index);
  }

  public double getLeftAxis() {
    return driveJoystick.getRawAxis(Axis.Z_AXIS.index);
  }

  public enum Axis {
    X_AXIS(0),
    Z_AXIS(2);

    private final int index;

    Axis(int index) {
      this.index = index;
    }
  }
}
