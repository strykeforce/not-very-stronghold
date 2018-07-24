package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team2767.commands.DriveTankSide;

public class Tank extends Subsystem {

  private static final int LEFTMASTER = 0;
  private static final int RIGHTMASTER = 1;
  private static final int LEFTSLAVE1 = 2;
  private static final int RIGHTSLAVE1 = 3;
  private static final int LEFTSLAVE2 = 4;
  private static final int RIGHTSLAVE2 = 5;

  private final TalonSRX rightMaster, leftMaster, rightSlave1, leftSlave1, rightSlave2, leftSlave2;

  @Override
  protected void initDefaultCommand() {
    setDefaultCommand(new DriveTankSide());
  }

  public Tank() {
    /*
    rightMaster = talons.getTalon(RIGHTMASTER);
    leftMaster = talons.getTalon(LEFTMASTER);
    rightSlave1 = talons.getTalon(RIGHTSLAVE1);
    leftSlave1 = talons.getTalon(LEFTSLAVE1);
    rightSlave2 = talons.getTalon(RIGHTSLAVE2);
    leftSlave2 =  talons.getTalon(LEFTSLAVE2);S
    */
    super();

    rightMaster = new TalonSRX(RIGHTMASTER);
    rightMaster.enableCurrentLimit(true);
    rightMaster.configContinuousCurrentLimit(40, 10);
    leftMaster = new TalonSRX(LEFTMASTER);
    leftMaster.enableCurrentLimit(true);
    leftMaster.configContinuousCurrentLimit(40, 10);
    rightSlave1 = new TalonSRX(RIGHTSLAVE1);
    rightSlave1.enableCurrentLimit(true);
    rightSlave1.configContinuousCurrentLimit(40, 10);
    leftSlave1 = new TalonSRX(LEFTSLAVE1);
    leftSlave1.enableCurrentLimit(true);
    leftSlave1.configContinuousCurrentLimit(40, 10);
    rightSlave2 = new TalonSRX(RIGHTSLAVE2);
    rightSlave2.enableCurrentLimit(true);
    rightSlave2.configContinuousCurrentLimit(40, 10);
    leftSlave2 = new TalonSRX(LEFTSLAVE2);
    leftSlave2.enableCurrentLimit(true);
    leftSlave2.configContinuousCurrentLimit(40, 10);

    if (rightMaster == null
        || leftMaster == null
        || rightSlave1 == null
        || leftSlave1 == null
        || rightSlave2 == null
        || leftSlave2 == null) {
      System.out.println("missing talons.");
    } else {
      rightSlave1.follow(rightMaster);
      rightSlave2.follow(rightMaster);
      leftSlave1.follow(leftMaster);
      leftSlave2.follow(leftMaster);
    }
  }

  public void driveAllPercent(double percent) {
    rightMaster.set(ControlMode.PercentOutput, percent);
    leftMaster.set(ControlMode.PercentOutput, -percent);
  }

  public void driveSidePercent(double leftPercent, double rightPercent) {
    rightMaster.set(ControlMode.PercentOutput, rightPercent);
    leftMaster.set(ControlMode.PercentOutput, -leftPercent);
  }
}
