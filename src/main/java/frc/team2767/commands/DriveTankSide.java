package frc.team2767.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2767.Robot;
import frc.team2767.control.Controls;
import frc.team2767.subsystem.Tank;

public class DriveTankSide extends Command {
  private static double MAXIMUM = .85;
  private static double DEAD = .1;

  private double rightPercent;
  private double leftPercent;
  private static Tank tank = Robot.TANK;
  private static Controls controls = Robot.CONTROLS;

  public DriveTankSide() {
    requires(tank);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    rightPercent = controls.getRightAxis();
    leftPercent = controls.getLeftAxis();
    System.out.println("PRE: " + rightPercent + ", " + leftPercent);

    if (Math.abs(rightPercent) < DEAD) {
      rightPercent = 0;
    } else {
      if (rightPercent > MAXIMUM) {
        rightPercent = MAXIMUM;
      } else if (rightPercent < -MAXIMUM) {
        rightPercent = -MAXIMUM;
      }
    }

    if (Math.abs(leftPercent) < DEAD) {
      leftPercent = 0;
    } else {
      if (leftPercent > MAXIMUM) {
        leftPercent = MAXIMUM;
      } else if (leftPercent < -MAXIMUM) {
        leftPercent = -MAXIMUM;
      }
    }
    System.out.println("POST: " + rightPercent + ", " + leftPercent);

    tank.driveSidePercent(leftPercent, rightPercent);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    tank.driveSidePercent(0, 0);
  }
}
