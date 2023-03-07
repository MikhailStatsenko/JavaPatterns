package PW7.Facade;

public class FlashDrive {
    private boolean data = false;
    public boolean hasData() {
        return data;
    }
    void loadToDisk() {
        System.out.println("Даные загружены на флешку");
        data = true;
    }
    void clearDisk() {
        System.out.println("Данные с флешки удалены");
        data = false;
    }
}
