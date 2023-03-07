package PW2;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> list =  List.of(
                new Human(21, 55, "Alex", "Alexov", LocalDate.of(2002, 11, 11)),
                new Human(18, 64, "Anton", "Johnson", LocalDate.of(2005, 10, 10)),
                new Human(24, 80, "Anna", "Sanchez", LocalDate.of(1999, 8, 12)),
                new Human(15, 40, "Arnold", "White", LocalDate.of(2008, 11, 11)),
                new Human(11, 22, "Helen", "Hicks", LocalDate.of(2002, 11, 11))
        );

        System.out.println("Сортировка по второй букве в обратном порядке");
        list.stream().sorted((a, b) -> ((Character) b.getFirstName().charAt(1)).compareTo(a.getFirstName().charAt(1))).forEach(System.out::println);

        System.out.println("\nВывод с весом меньше 60");
        list.stream().filter(x -> x.getWeight() < 60).forEach(System.out::println);

        System.out.println("\nСортировка по возрасту");
        list.stream().sorted((a,b) -> ((Integer)a.getAge()).compareTo(b.getAge())).forEach(System.out::println);

        System.out.println("\nСумма возрастов");
        System.out.println(list.stream().mapToInt(Human::getAge).sum());
    }
}
