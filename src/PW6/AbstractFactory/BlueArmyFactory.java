package PW6.AbstractFactory;

public class BlueArmyFactory implements ArmyFactory {
    @Override
    public Archers createArchers() {
        return new BlueArmyArchers();
    }

    @Override
    public Infantry createInfantry() {
        return new BlueArmyInfantry();
    }

    @Override
    public SiegeWeapons createSiegeWeapons() {
        return new BlueArmySiegeWeapons();
    }
}
