package PW6.Builder;

public class Main {
    public static void main(String[] args) {
        AirplaneBuilder builder = new AirFighterBuilder();
        AirplaneManufacturer manufacturer = new AirplaneManufacturer(builder);
        Airplane plane = manufacturer.manufactureAirplane();
        System.out.println(plane+"\n");

        builder = new LightAirplaneBuilder();
        manufacturer = new AirplaneManufacturer(builder);
        plane = manufacturer.manufactureAirplane();
        System.out.println(plane+"\n");

        builder = new AirlinerBuilder();
        manufacturer = new AirplaneManufacturer(builder);
        plane = manufacturer.manufactureAirplane();
        System.out.println(plane);
    }
}
