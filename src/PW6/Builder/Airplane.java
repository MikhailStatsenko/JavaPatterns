package PW6.Builder;

public class Airplane {
    private String airplaneType;
    private String engineType;
    private int engineCount;
    private int maxSpeed;
    private int maxPassengerCount;

    public Airplane(String airplaneType, String engineType, int engineCount, int maxSpeed, int maxPassengerCount) {
        this.airplaneType = airplaneType;
        this.engineType = engineType;
        this.engineCount = engineCount;
        this.maxSpeed = maxSpeed;
        this.maxPassengerCount = maxPassengerCount;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "airplaneType='" + airplaneType + '\'' +
                ", engineType='" + engineType + '\'' +
                ", engineCount=" + engineCount +
                ", maxSpeed=" + maxSpeed +
                ", maxPassengerCount=" + maxPassengerCount +
                '}';
    }
}
