package PW8.Command;

public class Main {
    public static void main(String[] args) {
        SubwayTrain train = new SubwayTrain();
        TrainDriver driver = new TrainDriver(new MoveForwardCommand(train),
                new StopCommand(train), new OpenDoorsCommand(train));
        driver.moveTrainForward();
        driver.stopTrain();
        driver.openTrainDoors();

    }
}
