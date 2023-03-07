package PW6.Builder;

public class LightAirplaneBuilder implements AirplaneBuilder {
    private String airplaneType;
    String engineType;
    int engineCount;
    int maxSpeed;
    int maxPassengerCount;

    @Override
    public AirplaneBuilder fixType() {
        this.airplaneType = "Light airplane";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineType() {
        this.engineType = "Turboprop";
        return this;
    }

    @Override
    public AirplaneBuilder fixEngineCount() {
        this.engineCount = 1;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxSpeed() {
        this.maxSpeed = 300;
        return this;
    }

    @Override
    public AirplaneBuilder fixMaxPassengerCount() {
        this.maxPassengerCount = 15;
        return this;
    }

    @Override
    public Airplane build() {
        return new Airplane(airplaneType, engineType, engineCount, maxSpeed, maxPassengerCount);
    }
}
