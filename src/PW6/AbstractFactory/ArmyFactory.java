package PW6.AbstractFactory;

public interface ArmyFactory {
    Archers createArchers();
    Infantry createInfantry();
    SiegeWeapons createSiegeWeapons();
}
