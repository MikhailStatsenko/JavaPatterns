package PW6.AbstractFactory;

public class RedArmySiegeWeapons implements SiegeWeapons {
    @Override
    public void storm() {
        System.out.println("Red siege weapons are storming the fortress");
    }
}
