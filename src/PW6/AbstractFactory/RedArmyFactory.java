package PW6.AbstractFactory;

public class RedArmyFactory implements ArmyFactory {
    @Override
    public Archers createArchers() {
        return new RedArmyArchers();
    }

    @Override
    public Infantry createInfantry() {
        return new RedArmyInfantry();
    }

    @Override
    public SiegeWeapons createSiegeWeapons() {
        return new RedArmySiegeWeapons();
    }
}
