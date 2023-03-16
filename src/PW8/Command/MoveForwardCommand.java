package PW8.Command;

public class MoveForwardCommand implements Command {
    private SubwayTrain train;

    public MoveForwardCommand(SubwayTrain train) {
        this.train = train;
    }

    @Override
    public void execute() {
        train.moveForward();
    }
}
