package PW6.Builder;

public interface AirplaneBuilder {
    AirplaneBuilder fixType();
    AirplaneBuilder fixEngineType();
    AirplaneBuilder fixEngineCount();
    AirplaneBuilder fixMaxSpeed();
    AirplaneBuilder fixMaxPassengerCount();
    Airplane build();
}
