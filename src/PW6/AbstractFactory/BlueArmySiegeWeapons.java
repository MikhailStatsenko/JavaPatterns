package PW6.AbstractFactory;

public class BlueArmySiegeWeapons implements SiegeWeapons {
    @Override
    public void storm() {
        System.out.println("Blue siege weapons are storming the fortress");
    }
}
