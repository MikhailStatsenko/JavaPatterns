package PW7.Facade;

public class SSD {
    void copyFromFlash(FlashDrive drive) {
        if (drive.hasData()) {
            System.out.println("Данные скопированы на SSD");
        } else {
            System.out.println("Внешний диск пустой, копировать нечего");
        }
    }
}
