package PW8.Strategy;

public class Main {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient(new BubbleSort());

        int arr1[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        client.executeStrategy(arr1);

        System.out.println();

        arr1 = new int[]{100, 90, 80, 70, 60, 50, 40, 30, 20, 10};
        client.setStrategy(new QuickSort());
        client.executeStrategy(arr1);
    }
}
