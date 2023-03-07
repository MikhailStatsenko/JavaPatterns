package PW6.AbstractFactory;

public class Army {
    private final Archers archers;
    private final Infantry infantry;
    private final SiegeWeapons siegeWeapons;

    public Army(ArmyFactory factory) {
        this.archers = factory.createArchers();
        this.infantry = factory.createInfantry();
        this.siegeWeapons = factory.createSiegeWeapons();
    }

    public void attack() {
        archers.shoot();
        infantry.attack();
        siegeWeapons.storm();
    }
}
