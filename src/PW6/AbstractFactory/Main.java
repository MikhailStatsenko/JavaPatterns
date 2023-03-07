package PW6.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        ArmyFactory red = new RedArmyFactory();
        Army redArmy = new Army(red);

        ArmyFactory blue = new BlueArmyFactory();
        Army blueArmy = new Army(blue);

        redArmy.attack();
        System.out.println();
        blueArmy.attack();
    }
}
