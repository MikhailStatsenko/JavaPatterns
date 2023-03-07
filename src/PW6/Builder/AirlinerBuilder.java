package PW6.Builder;

public class AirlinerBuilder implements AirplaneBuilder {
    private String airplaneType;
    String engineType;
    int engineCount;
    int maxSpeed;
    int maxPassengerCount;

    @Override
    public AirplaneBuilder fixType() {
        this.airplaneType = "Airliner";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineType() {
        this.engineType = "Air-jet engines";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineCount() {
        this.engineCount = 4;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxSpeed() {
        this.maxSpeed = 900;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxPassengerCount() {
        this.maxPassengerCount = 400;
        return this;
    }

    @Override
    public Airplane build() {
        return new Airplane(airplaneType, engineType, engineCount, maxSpeed, maxPassengerCount);
    }
}
