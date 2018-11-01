package frc.team2767;

import dagger.BindsInstance;
import dagger.Component;
import frc.team2767.subsystem.Coconut;
import frc.team2767.subsystem.Shooter;
import frc.team2767.subsystem.ShooterShoulder;
import java.net.URL;
import javax.inject.Singleton;
import org.strykeforce.thirdcoast.swerve.GyroModule;
import org.strykeforce.thirdcoast.swerve.WheelModule;
import org.strykeforce.thirdcoast.telemetry.NetworkModule;
import org.strykeforce.thirdcoast.telemetry.TelemetryService;

@Singleton
@Component(modules = {NetworkModule.class, GyroModule.class, WheelModule.class})
public interface RobotComponents {

  Coconut coconutSubsystem();

  Shooter shooterSubsystem();

  ShooterShoulder shooterShoulderSubsystem();

  TelemetryService telemetryService();

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder thirdCoastConfig(URL config);

    RobotComponents build();
  }
}
