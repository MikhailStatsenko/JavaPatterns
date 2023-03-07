package PW6.AbstractFactory;

public class BlueArmyInfantry implements Infantry {
    @Override
    public void attack() {
        System.out.println("Blue infantry attacks the enemy");
    }
}
