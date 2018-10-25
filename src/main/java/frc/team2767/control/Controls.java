package frc.team2767.control;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team2767.commands.coconut.*;
import frc.team2767.commands.shooter.ShooterOff;
import frc.team2767.commands.shooter.ShooterOn;
import frc.team2767.commands.shooterShoulder.ShoulderDown;
import frc.team2767.commands.shooterShoulder.ShoulderStop;
import frc.team2767.commands.shooterShoulder.ShoulderUp;

public class Controls {

  private Joystick driveJoystick;
  private JoystickButton rightSwitch;
  private JoystickButton leftForward;
  private JoystickButton leftBack;

  private JoystickButton upButton;
  private JoystickButton downButton;

  private JoystickButton rightForward;

  private static final int USB = 1;

  private static double MAXIMUM = .85;
  private static double DEAD = .05;

  public Controls() {

    System.out.println("Controls are constructed");

    if (DriverStation.getInstance().getJoystickName(USB).isEmpty()) {
      System.out.println("missing joystick");
    }

    driveJoystick = new Joystick(USB);
    rightSwitch = new JoystickButton(driveJoystick, 2);
    leftForward = new JoystickButton(driveJoystick, 4);
    leftBack = new JoystickButton(driveJoystick, 5);

    upButton = new JoystickButton(driveJoystick, 16);
    downButton = new JoystickButton(driveJoystick, 17);

    rightForward = new JoystickButton(driveJoystick, 4);

    leftForward.whenPressed(new CoconutSetForward());
    leftForward.whenReleased(new CoconutStop());
    leftBack.whenPressed(new CoconutSetBack());
    leftBack.whenReleased(new CoconutStop());

    upButton.whenPressed(new ShoulderUp());
    upButton.whenReleased(new ShoulderStop());
    downButton.whenPressed(new ShoulderDown());
    downButton.whenReleased(new ShoulderStop());

    rightForward.whenPressed(new ShooterOn());
    rightForward.whenReleased(new ShooterOff());
  }

  public double getRightAxis() {
    return -driveJoystick.getRawAxis(Axis.X_AXIS.index);
  }

  public double getLeftAxis() {
    return -driveJoystick.getRawAxis(Axis.Z_AXIS.index);
  }

  public double scrubAxisOutput(double axis) {
    if (Math.abs(axis) < DEAD) {
      return 0;
    } else {
      if (axis > MAXIMUM) {
        axis = MAXIMUM;
      } else if (axis < -MAXIMUM) {
        axis = -MAXIMUM;
      }
    }
    return axis;
  }

  public enum Axis {
    Z_AXIS(2),
    X_AXIS(0);

    private final int index;

    Axis(int index) {
      this.index = index;
    }
  }
}
