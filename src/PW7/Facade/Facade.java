package PW7.Facade;

public class Facade {
    private Power power = new Power();
    private FlashDrive flashDrive = new FlashDrive();
    private SSD ssd = new SSD();

    void copyData() {
        power.turnOn();
        flashDrive.loadToDisk();
        ssd.copyFromFlash(flashDrive);
    }
}
