package PW8.Command;

public class OpenDoorsCommand implements Command {
    private SubwayTrain train;

    public OpenDoorsCommand(SubwayTrain train) {
        this.train = train;
    }

    @Override
    public void execute() {
        train.openDoors();
    }
}
