package PW6.Prototype;

public abstract class Pen implements Cloneable {
    protected String color;
    protected int inkLevel;

    public abstract void write();

    public Pen(String color, int inkLevel) {
        this.color = color;
        this.inkLevel = inkLevel;
    }

    public int checkInkLevel() {
        return inkLevel;
    }

    @Override
    public Pen clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return (Pen) clone;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color='" + color + '\'' +
                ", inkLevel=" + inkLevel +
                '}';
    }
}
