package PW6.Prototype;

public class GelPen extends Pen{
    public GelPen(String color, int inkLevel) {
        super(color, inkLevel);
    }

    @Override
    public void write() {
        if (inkLevel == 0)
            System.out.println("Can't write, out of ink");
        else if (inkLevel - 25 < 0) {
            System.out.println("I just started writing and gel pen ran out of ink");
            inkLevel = 0;
        } else {
            System.out.println("Writing " + color + "letters with gel pen, ink level: " + inkLevel);
            inkLevel -= 25;
        }
    }
}
