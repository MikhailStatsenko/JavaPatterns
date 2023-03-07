package PW6.AbstractFactory;

public class RedArmyInfantry implements Infantry {
    @Override
    public void attack() {
        System.out.println("Red infantry attacks the enemy");
    }
}
