package frc.team2767.subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.strykeforce.thirdcoast.talon.Talons;

public class Tank extends Subsystem {
    private static final int LEFTMASTER = 0;
    private static final int RIGHTMASTER = 1;
    private static final int LEFTSLAVE1 = 2;
    private static final int RIGHTSLAVE1 = 3;
    private static final int LEFTSLAVE2 = 4;
    private static final int RIGHTSLAVE2 = 5;

    private final TalonSRX rightMaster, leftMaster, rightSlave1, leftSlave1, rightSlave2, leftSlave2;

    public Tank(Talons talons){
        rightMaster = talons.getTalon(RIGHTMASTER);
        leftMaster = talons.getTalon(LEFTMASTER);
        rightSlave1 = talons.getTalon(RIGHTSLAVE1);
        leftSlave1 = talons.getTalon(LEFTSLAVE1);
        rightSlave2 = talons.getTalon(RIGHTSLAVE2);
        leftSlave2 =  talons.getTalon(LEFTSLAVE2);

        if (rightMaster == null || leftMaster == null || rightSlave1 == null || leftSlave1 == null || rightSlave2 == null || leftSlave2 == null) {
            System.out.println("missing talons.");
        }
        else {
            rightSlave1.follow(rightMaster);
            rightSlave2.follow(rightMaster);
            leftSlave1.follow(leftMaster);
            leftSlave2.follow(leftMaster);
        }
    }


}
