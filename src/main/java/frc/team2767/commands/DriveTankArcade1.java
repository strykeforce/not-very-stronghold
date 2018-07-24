package frc.team2767.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team2767.Robot;
import frc.team2767.control.Controls;
import frc.team2767.subsystem.Tank;

public class DriveTankArcade1 extends Command {
  private static double MAXIMUM = .85;
  private static double DEAD = .1;

  private double steer;
  private double throttle;
  private double proportion = .5;
  private double leftPercentDrive;
  private double rightPercentDrive;
  private static Tank tank = Robot.TANK;
  private static Controls controls = Robot.CONTROLS;

  public DriveTankArcade1() {
    requires(tank);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    steer = controls.scrubAxisOutput(controls.getLeftAxis());
    throttle = controls.scrubAxisOutput(controls.getRightAxis());
    System.out.println("PRE: " + steer + ", " + throttle);

    leftPercentDrive = controls.scrubAxisOutput(throttle - (proportion * steer));
    rightPercentDrive = controls.scrubAxisOutput(throttle + (proportion * steer));

    System.out.println("POST: " + rightPercentDrive + ", " + leftPercentDrive);

    tank.driveSidePercent(leftPercentDrive, rightPercentDrive);
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
