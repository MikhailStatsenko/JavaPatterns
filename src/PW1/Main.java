package PW1;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Predicate<String> email = (s) -> Pattern.matches("[A-Za-z0-9_\\.]{8,}@[a-z]+\\.[a-z]{2,}", s);
        System.out.println(email.test("hello123@mail.ru"));
        System.out.println(email.test("hello456@mail"));
        System.out.println(email.test("hello789@mail."));
    }
}
