package PW5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SingletonLazy lazy1 = SingletonLazy.getInstance();
        SingletonLazy lazy2 = SingletonLazy.getInstance();
        System.out.println("Lazy: "+lazy1.equals(lazy2));

        SingletonEnum enum1 = SingletonEnum.INSTANCE;
        SingletonEnum enum2 = SingletonEnum.INSTANCE;
        System.out.println("Enum: "+enum1.equals(enum2));

        SingletonHold hold1 = SingletonHold.getInstance();
        SingletonHold hold2 = SingletonHold.getInstance();
        System.out.println("Hold: "+hold1.equals(hold2));
    }
}
