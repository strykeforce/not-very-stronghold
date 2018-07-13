package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Tank extends Subsystem {

  private static final int LEFTMASTER = 0;
  private static final int RIGHTMASTER = 1;
  private static final int LEFTSLAVE1 = 2;
  private static final int RIGHTSLAVE1 = 3;
  private static final int LEFTSLAVE2 = 4;
  private static final int RIGHTSLAVE2 = 5;

  private final TalonSRX rightMaster, leftMaster, rightSlave1, leftSlave1, rightSlave2, leftSlave2;

  @Override
  protected void initDefaultCommand() {}

  public Tank() {
    /*
    rightMaster = talons.getTalon(RIGHTMASTER);
    leftMaster = talons.getTalon(LEFTMASTER);
    rightSlave1 = talons.getTalon(RIGHTSLAVE1);
    leftSlave1 = talons.getTalon(LEFTSLAVE1);
    rightSlave2 = talons.getTalon(RIGHTSLAVE2);
    leftSlave2 =  talons.getTalon(LEFTSLAVE2);
    */

    rightMaster = new TalonSRX(RIGHTMASTER);
    leftMaster = new TalonSRX(LEFTMASTER);
    rightSlave1 = new TalonSRX(RIGHTSLAVE1);
    leftSlave1 = new TalonSRX(LEFTSLAVE1);
    rightSlave2 = new TalonSRX(RIGHTSLAVE2);
    leftSlave2 = new TalonSRX(LEFTSLAVE2);

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
    rightSlave1.set(ControlMode.PercentOutput, percent);
    leftSlave1.set(ControlMode.PercentOutput, -percent);
    rightSlave2.set(ControlMode.PercentOutput, percent);
    leftSlave2.set(ControlMode.PercentOutput, -percent);
  }
}
