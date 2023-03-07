package PW6.Prototype;

public class Main {
    public static void main(String[] args) {
        Pen autopen = new Autopen("red", 35),
                gelPen = new GelPen("green", 35),
                capillaryPen = new CapillaryPen("blue", 35);
        Pen autopenClone = autopen.clone(),
                gelPenClone = gelPen.clone(), capillaryPenClone = capillaryPen.clone();

        autopenClone.write();
        autopenClone.write();
        autopenClone.write();
        autopenClone.write();
        System.out.println("Ink level of original autopen: " + autopen.checkInkLevel() + "\n");

        gelPenClone.write();
        gelPenClone.write();
        gelPenClone.write();
        System.out.println("Ink level of original gel pen: " + gelPen.checkInkLevel() + "\n");

        capillaryPenClone.write();
        capillaryPenClone.write();
        capillaryPenClone.write();
        capillaryPenClone.write();
        capillaryPenClone.write();
        System.out.println("Ink level of original gel pen: " + capillaryPen.checkInkLevel() + "\n");

    }
}
