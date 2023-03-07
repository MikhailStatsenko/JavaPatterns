package PW5;

public class SingletonHold {
    private SingletonHold(){}

    private static class SingletonHolder {
        public static final SingletonHold HOLDER_INSTANCE = new SingletonHold();
    }

    public static SingletonHold getInstance() {
        return SingletonHolder.HOLDER_INSTANCE;
    }
}
