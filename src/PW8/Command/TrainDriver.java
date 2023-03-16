package PW8.Command;

public class TrainDriver {
    Command moveForward;
    Command stop;
    Command openDoors;

    public TrainDriver(Command moveForward, Command stop, Command openDoors) {
        this.moveForward = moveForward;
        this.stop = stop;
        this.openDoors = openDoors;
    }
    void moveTrainForward() {
        moveForward.execute();
    }
    void stopTrain() {
        stop.execute();
    }
    void openTrainDoors() {
        openDoors.execute();
    }
}
