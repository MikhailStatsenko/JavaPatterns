package PW6.Builder;

public class AirFighterBuilder implements AirplaneBuilder {
    private String airplaneType;
    private String engineType;
    private int engineCount;
    private int maxSpeed;
    private int maxPassengerCount;

    @Override
    public AirplaneBuilder fixType() {
        this.airplaneType = "Air fighter";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineType() {
        this.engineType = "Turbojet engine";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineCount() {
        this.engineCount = 2;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxSpeed() {
        this.maxSpeed = 2778;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxPassengerCount() {
        this.maxPassengerCount = 1;
        return this;
    }

    @Override
    public Airplane build() {
        return new Airplane(airplaneType, engineType, engineCount, maxSpeed, maxPassengerCount);
    }
}
