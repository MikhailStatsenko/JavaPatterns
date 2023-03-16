package PW8.Strategy;

public class StrategyClient {
    Sorting strategy;

    public StrategyClient(Sorting strategy) {
        this.strategy = strategy;
    }
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}
