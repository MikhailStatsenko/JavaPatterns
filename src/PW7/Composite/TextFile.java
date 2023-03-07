package PW7.Composite;

public class TextFile implements File {
    @Override
    public void printType() {
        System.out.println("Это текстовый файл");
    }
}
