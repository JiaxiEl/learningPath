- Exception: represent unexpected events or errors that occur during the execution of a program
  - Handling:
    - try-catch
    - throws
    - ex
  - Checked Exception: exceptions that are checked at compile time.
    - using try-catch or throws
    - IOException, SQLException
  - Unchecked Exception(Runtime Exception): exception occur during runtime
    - NullPointerException, ArrayIndexOutOfBoundsException
  - Errors: represent serious issues that application should not try to catch
    - OutOfMemoryError, StackOverflowError


- Basic Exception Handling
```aiignore
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
} finally {
    System.out.println("End of try-catch-finally block.");
}
```

- Custom Exceptions:
```aiignore
class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}

public class TestCustomException{
    public static void main(String[] args){
        try{
            throw new CustomException("This is a custom exception");
        }catch(CustomException e){
            System.out.printlb(e.getMessage());
        }
    
    }

}
```
- finally: A block that follows the try or catch block.
  - always executed regardless of whether an exception was thrown or not.

    
- throw: used to explicity throw an exception and trigger an exception when certain conditions occur
```aiignore
public class ThrowExample {
    public static void validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        } else {
            System.out.println("Welcome!");
        }
    }

    public static void main(String[] args) {
        validateAge(16);
    }
}

```


- throws: Declares that a method may throw an exception. It is placed in the method signature to inform the caller of the method that it may need to handle exceptions thrown by this method
```aiignore
import java.io.IOException;

public class ThrowsExample {
    public static void riskyMethod() throws IOException {
        throw new IOException("Simulated IOException");
    }

    public static void main(String[] args) {
        try {
            riskyMethod();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

```


- Enum(Enumerator)
```aiignore
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class EnumExample {
    public static void main(String[] args) {
        Day today = Day.MONDAY;
        System.out.println("Today is: " + today);

        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week!");
                break;
            case FRIDAY:
                System.out.println("End of the work week!");
                break;
            default:
                System.out.println("Midweek.");
        }
    }
}

```
 - Enumerator can have default values:
```aiignore
enum TrafficLight {
    RED(30), 
    YELLOW(5), 
    GREEN(60);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + " duration: " + light.getDuration() + " seconds");
        }
    }
}

```

- Default Field Values without Arguments:
```aiignore
enum Size {
    SMALL(10), 
    MEDIUM(20), 
    LARGE; 

    private final int value;

    Size() {
        this.value = 30; 
    }

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class EnumWithDefaultExample {
    public static void main(String[] args) {
        System.out.println("SMALL size value: " + Size.SMALL.getValue()); 
        System.out.println("MEDIUM size value: " + Size.MEDIUM.getValue()); 
        System.out.println("LARGE size value: " + Size.LARGE.getValue()); 
    }
}

```

















