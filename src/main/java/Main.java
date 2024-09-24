import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // Instance method reference for arbitrary Person objects
        people.forEach(person -> System.out.println(person.getName()));  // Lambda version
        people.forEach(System.out::println);  // Simplified version using method reference
    }
}
