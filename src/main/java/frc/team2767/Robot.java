package frc.team2767;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.team2767.control.Controls;
import frc.team2767.subsystem.Coconut;
import frc.team2767.subsystem.Shooter;
import frc.team2767.subsystem.ShooterShoulder;
import frc.team2767.subsystem.Tank;
import org.jetbrains.annotations.NotNull;
import org.strykeforce.thirdcoast.telemetry.TelemetryController;
import org.strykeforce.thirdcoast.telemetry.TelemetryService;
import org.strykeforce.thirdcoast.telemetry.grapher.ClientHandler;

import java.net.DatagramSocket;
import java.net.SocketException;

public class Robot extends TimedRobot {
    public static final Tank TANK = new Tank();
    public static final Coconut COCONUT = new Coconut();
    public static final Shooter SHOOTER = new Shooter();
    public static final ShooterShoulder SHOOTER_SHOULDER = new ShooterShoulder();

    public static final Controls CONTROLS = new Controls();
    private static final int CLIENT_PORT = 5801; // grapher client listens on this
    private static final int SERVER_PORT = 5800; // roborio listens on this
    public static final TelemetryService TELEMETRY = getTelemetryService();
    private Scheduler scheduler;

    @NotNull
    private static TelemetryService getTelemetryService() {
        // Create a TelemetryService using manual dependency injection.
        //
        // TelemetryService is instantiated with a TelemetryController factory functional interface:
        //   inventory -> new TelemetryController
        //
        // The inventory is managed internally by the TelemetryService and updated when you register
        // talons, etc.
        //
        // The injected TelemetryController class listens for HTTP requests from telemetry clients.
        // The injected ClientHandler class provides the UDP data stream to the telemetry client. One
        // client at at time is supported for streaming.
        // The injected DatagramSocket is the source socket that datagrams are sent through.

        return new TelemetryService(
                inventory -> {
                    DatagramSocket datagramSocket; // grr checked exceptions...
                    try {
                        datagramSocket = new DatagramSocket();
                    } catch (SocketException se) {
                        throw new RuntimeException(se);
                    }
                    return new TelemetryController(
                            inventory, new ClientHandler(CLIENT_PORT, datagramSocket), SERVER_PORT);
                });
    }

    @Override
    public void robotInit() {
        System.out.println("Hello!");
        scheduler = Scheduler.getInstance();
    }

    @Override
    public void teleopPeriodic() {
        scheduler.run();
    }
}