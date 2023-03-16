package PW8.Command;

public class StopCommand implements Command {
    private SubwayTrain train;

    public StopCommand(SubwayTrain train) {
        this.train = train;
    }

    @Override
    public void execute() {
        train.stop();
    }
}
