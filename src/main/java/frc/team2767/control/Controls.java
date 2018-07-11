package frc.team2767.control;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;

public class Controls {

    Joystick driveJoystick;


    private static final int USB = 1;
    public Controls() {
        if (DriverStation.getInstance().getJoystickName(USB).isEmpty()) {
            System.out.println("missing joystick");
        }
        driveJoystick = new Joystick(USB);
    }


    public double getRightAxis (){
        return driveJoystick.getRawAxis(Axis.X_AXIS.index);
    }

    public double getLeftAxis (){
        return driveJoystick.getRawAxis(Axis.Z_AXIS.index);
    }

    public enum Axis{
        X_AXIS(0),
        Z_AXIS(2);

        private final int index;

        Axis(int index){ this.index = index;}
    }
}
