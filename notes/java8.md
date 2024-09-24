## Java 8
- **Functional Interface
  - One single abstract method
  - Can have a lot of default method

## Consumer
- **Consumer** : have argument, but no return 
  - Consumer: void accept(T)
  - BigConsumer: void accept(T t, U u)
  - DoubleConsumer: void accept(double value)
  - IntConsumer: void accept(int value)
  - LongConsumer: void accept(long value)
  - ObjDoubleConsumer: void accept(T t, double value)

## Supplier
- **Supplier** : no argument, with return value
  - Supplier
  - BooleanSupplier
  - DoubleSupplier
  - IntSupplier
  - LongSupplier

## Predicate
- **Predicate** : have argument, return boolean value
  - Predicate
  - BiPredicate<T,U>
  - DoublePredicate
  - IntPredicate
  - LongPredicate

## Function
- **Function** : Have argument and return value


| Interface              | Method Signature              | Description                                      |
|------------------------|-------------------------------|--------------------------------------------------|
| **`Consumer<T>`**       | `void accept(T t)`            | Takes one argument, performs an action, no result |
| **`BiConsumer<T, U>`**  | `void accept(T t, U u)`       | Takes two arguments, performs an action, no result|
| **`Supplier<T>`**       | `T get()`                     | Provides a result, no input                      |
| **`Predicate<T>`**      | `boolean test(T t)`           | Tests a condition and returns a boolean          |
| **`Function<T, R>`**    | `R apply(T t)`                | Transforms one argument into a result            |
| **`BiFunction<T, U, R>`** | `R apply(T t, U u)`         | Transforms two arguments into a result           |
| **`UnaryOperator<T>`**  | `T apply(T t)`                | Takes one argument and returns the same type     |
| **`BinaryOperator<T>`** | `T apply(T t1, T t2)`         | Takes two arguments of the same type, returns the same type |





## Java uses functional interfaces instead of directly implementing functions
- Everything in Java must belong to a class.
- Functional interfaces act as a way to encapsulate a function with an object
- Reusability with Functional Interfaces, for example across the Java API especially in the steam API.
- Cleaner Syntax with Lambdas
- Functional Interfaces are Flexible and Composable

## lambda expressions
- Omitting {}:a single expression
- a single expression: multiple lines of code 
- Omitting () (Single Parameter Without Type) :nly one parameter and its type is inferred by the compiler
- When () is Required: no parameters, Multiple Parameters, Explicit Type Declaration


## Important
- Lambda can use unchanged variable outside of lambda: Final Variable, non-final variable however never changed, Object variable



## Method Reference
- Static Method Reference: ClassName::staticMethod
```aiignore
Comparator<Integer> comparator = Integer::compare;
Comparator<Integer> comparatorLambda = (a, b) -> Integer.compare(a, b);
```
- Instance Method Reference of a Particular Object: instance::instanceMethod
```aiignore
PrintStream printer = System.out;
Runnable task = printer::println;
Runnable taskLambda = () -> System.out.println();
```
- Instance Method Reference of an Arbitrary Object of a Particular Type: ClassName::instanceMethod
```aiignore
Function<String, Integer> stringLength = String::length;

Function<String, Integer> stringLengthLambda = s -> s.length();
```
- Constructor Reference: ClassName::new
- 



## Create Optional<T> 
- Optional<T>: container class that either contain a value of Type T or empty
- Optional.empty(): Creates an empty Optional with no value
- Optional.of(T value) :Create Optional when sure that the value is non-value
- Optional.ofNullable(T value): Create Optional, when the value might be null, it will return empty 

## Get Element from optional:
- get(): Retrieve the value if present, throw NoSuchElementException if empty
- orElse(T other): Return the value if present, otherwise, return provided default value
- orElseGet(supplier <? extend T> other): Similar to orElse(), but take a supplier to provide the default value only when needed
- orElseThrow(): Return the value if present, but throws an exception if the Optional is empty

## Check the presence of a value of a value:
- isPresent(): Return true if a value is present
- ifPresent(): Given a lambda if a value is present

## Transforming Values with map() and flatMap():
- map(): if a value is present, map() applies the given function to transform the value inside the Optional
```aiignore
Optional<String> opt = Optional.of("John");

Optional<String> upperCaseName = opt.map(String::toUpperCase);

System.out.println(upperCaseName.orElse("No Name"));
```
- flatMap(): similar to map(), but the function you provide must return an Optional
```aiignore
Optional<String> opt = Optional.of("John");
Optional<String> upperCaseName = opt.flatMap(name -> Optional.of(name.toUpperCase()));
System.out.println(upperCaseName.orElse("No Name"));
```

## Filtering Values with filter()
-filter(): conditionally retain the value in the Optional based on a predicate. If the condition is met, the Optional is returned, otherwise, an empty Optional is returned.

## Chaining Optional Operations
```aiignore
Optional<String> opt = Optional.of("John");
String result = opt
                .filter(name -> name.startsWith("J"))
                .map(String::toUpperCase)
                .orElse("Default Name");
```


## Stream API
- Stream API: allows you to express complex data processing queries and transformations in a readable and declarative way
- Supports different types of operations
- Stream is not a data structure
- Stream is lazy
- stream supports both sequential and parallel execution

- Creating Streams
  - From a Collection:
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Stream<String> nameStream = names.stream();

```
  - From Arrays:
```aiignore
int\[\] numbers = {1, 2, 3, 4, 5};
IntStream numberStream = Arrays.stream(numbers);

```
 - From Values(stream.of)
```aiignore
Stream<String> streamOfValues = Stream.of("Java", "Python", "C++");
```

 -  Infinite Streams
```aiignore
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
```

## Stream Operations
- Intermediate operations: filter(), map(), sorted
- Terminal operations: forEach(), collect(), reduce()


- filter(): Based on a predicate(condition). Only elements that match the condition are included in the output stream
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
    .filter(name -> name.startsWith("A"))
    .forEach(System.out::println());
```

- map(): Transforms each element of the stream into another object, it's used for mapping elements to new value
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .map(String::toUpperCase)
     .forEach(System.out::println); 
```

- sorted():Sorts the element in natural order or using a custom comparator
```aiignore
List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 3);
numbers.stream()
       .sorted()
       .forEach(System.out::println);

```

- distinct():Removes duplicate elements from the stream.
```aiignore
List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 4, 5);
numbers.stream()
       .distinct()
       .forEach(System.out::println);  // Outputs: 1, 2, 3, 4, 5

```

- limit(): Limits the size of the stream to the given number of elements.
```aiignore
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
infiniteStream
     .limit(5)
     .forEach(System.out::println);  // Outputs: 0, 1, 2, 3, 4

```


- skip(): Skips the first n elements of the stream.
```aiignore
Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 1);
infiniteStream
     .skip(5)
     .limit(5)
     .forEach(System.out::println);  // Outputs: 5, 6, 7, 8, 9

```


## Terminal Operations
- forEach(): Performs an action (e.g., print) on each element of the stream.
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.stream()
     .forEach(System.out::println); 
```

- collect(): Collects the elements of the stream into a collection (like a List, Set, etc.).
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
List<String> filteredNames = names.stream()
     .filter(name -> name.length() > 3)
     .collect(Collectors.toList());

System.out.println(filteredNames);

```

- reduce(): Combines all elements of the stream into a single result by applying a binary operator (e.g., sum, product).
```aiignore
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
int sum = number.stream()
                .reduce(0, (a, b) -> a + b)
```


- count(): Returns the number of elements in the stream.
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
long count = names.stream()
     .filter(name -> name.length() > 3)
     .count();

System.out.println(count);

```

- findFirst(): Returns the first element in the stream (wrapped in an Optional).
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
Optional<String> first = names.stream()
     .findFirst();

first.ifPresent(System.out::println);

```


- allMatch() / anyMatch() / noneMatch(): These methods check if all, any, or none of the elements in the stream match a given predicate.
```aiignore
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

boolean allEven = numbers.stream().allMatch(n -> n % 2 == 0);
boolean anyEven = numbers.stream().anyMatch(n -> n % 2 == 0); 
boolean noneNegative = numbers.stream().noneMatch(n -> n < 0); 

```


## Parallel Streams: process elements in parallel, taking advantage of multiple CPU cores.
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.parallelStream()
     .map(String::toUpperCase)
     .forEach(System.out::println);

```


## Chaining Stream Operations
```aiignore
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<String> result = names.stream()
     .filter(name -> name.startsWith("A"))  
     .map(String::toUpperCase)              
     .sorted()                            
     .collect(Collectors.toList());   

System.out.println(result);

```


## Working with Primitive Streams: The Stream API has specialized stream types for working with primitive type like int long and double
- IntStream for int
- LongStream for long
- DoubleStream for double




















