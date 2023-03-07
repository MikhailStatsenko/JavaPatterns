package PW7.Composite;

public class Main {
    public static void main(String[] args) {
        File textFile1 = new TextFile();
        File textFile2 = new TextFile();
        File mediaFile1 = new MediaFile();

        File systemFile1 = new SystemFile();
        File mediaFile2 = new MediaFile();
        File systemFile2 = new SystemFile();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(textFile1);
        composite1.addComponent(textFile2);
        composite1.addComponent(mediaFile1);

        composite2.addComponent(systemFile1);
        composite2.addComponent(mediaFile2);
        composite2.addComponent(systemFile2);

        composite.addComponent(composite1);
        composite.addComponent(composite2);

        composite.printType();
    }
}
