package PW6.Prototype;

public class CapillaryPen extends Pen{

    public CapillaryPen(String color, int inkLevel) {
        super(color, inkLevel);
    }

    @Override
    public void write() {
        if (inkLevel == 0)
            System.out.println("Can't write, out of ink");
        else if (inkLevel - 10 < 0) {
            System.out.println("I just started writing and capillary pen ran out of ink");
            inkLevel = 0;
        } else {
            System.out.println("Writing " + color + "letters with capillary pen, ink level: " + inkLevel);
            inkLevel -= 10;
        }
    }
}
