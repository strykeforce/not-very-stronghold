package frc.team2767.control;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
  }

  public double getRightAxis() {
    return -driveJoystick.getRawAxis(Axis.Y_AXIS.index);
  }

  public double getLeftAxis() {
    return -driveJoystick.getRawAxis(Axis.Z_AXIS.index);
  }

  public enum Axis {
    Y_AXIS(1),
    Z_AXIS(2);

    private final int index;

    Axis(int index) {
      this.index = index;
    }
  }
}
