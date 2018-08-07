# not-very-stronghold

## Adding a Subsystem

Follow these steps for each subsystem.

Annotate the subsystem with `@Singleton` to allow [only one copy](https://youtu.be/YemDH30Yhno) of this class to be created.

```java
// Coconut.java
@Singleton
public class Coconut extends Subsystem {
  // ...
```

Annotate the subsystem constructor with `@Inject` to allow the class to be automatically instantiated by dependency injection. If using Talons, add `Talons` to the constructor to have it injected for your use.

Add talons to the `TelemetryService` to allow graphing.

```java
// Coconut.java
@Inject
public Coconut(Talons talons) {
  coconutTalon = talons.getTalon(40); // get pre-configured Talon
  Robot.COMPONENTS.telemetryService().register(new TalonItem(coconutTalon, "Coconut Talon (40)")); // add Talon to grapher
  // ...
```

Add a method declaration for getting the subsystem instance to the `RobotComponents` interface.

```java
// RobotComponents.java
Coconut coconutSubsystem();
```

## Using a Subsystem

Once a subsystem is configured you can use it in commands, for example:

```java
// CoconutStop.java
public class CoconutStop extends InstantCommand {
  private final Coconut COCONUT = Robot.COMPONENTS.coconutSubsystem();

  @Override
  protected void initialize() {
    COCONUT.stop();
  }

  public CoconutStop() {
    requires(COCONUT);
  }
}
```

## Talons

Subsystem        | Talon          | ID | PDP
---------------- | -------------- | -- | ---
Drive            | left-master    | 0  |
Drive            | right-master   | 1  |
Drive            | left-slave-1   | 2  |
Drive            | right-slave-1  | 3  |
Drive            | left-slave-2   | 4  |
Drive            | right-slave-2  | 5  |
Shooter          | left           | 20 |
Shooter          | right          | 21 |
Shooter-shoulder | elevation      | 30 |
Coconut          | coconut        | 40 |
Intake           | shoulder-left  | 50 |
Intake           | shoulder-right | 51 |
Intake           | roller         | 52 |
