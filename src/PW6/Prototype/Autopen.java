package PW6.Prototype;

public class Autopen extends Pen{
    public Autopen(String color, int inkLevel) {
        super(color, inkLevel);
    }

    @Override
    public void write() {
        if (inkLevel == 0)
            System.out.println("Can't write, out of ink");
        else if (inkLevel - 15 < 0) {
            System.out.println("I just started writing and autopen ran out of ink");
            inkLevel = 0;
        } else {
            System.out.println("Writing " + color + "letters with autopen, ink level: " + inkLevel);
            inkLevel -= 15;
        }
    }
}
