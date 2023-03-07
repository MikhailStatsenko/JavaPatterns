package PW6.Builder;

public class AirplaneManufacturer {
    AirplaneBuilder builder;

    public AirplaneManufacturer(AirplaneBuilder builder) {
        this.builder = builder;
    }

    public Airplane manufactureAirplane() {
        return builder.fixType().fixEngineType().fixEngineCount().fixMaxSpeed().fixMaxPassengerCount().build();
    }
}
