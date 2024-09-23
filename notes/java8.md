## Java 8
- **Functional Interface
  - One single abstract method
  - Can have a lot of default method

## Consumer
- **Consumer** : have argument, but no return 
  - Consumer: void accept(T t)
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
- Reusability with Functional Interfaces, for exmaple across the Java API espeically in the steam API.
- Cleaner Syntax with Lambdas
- Functional Interfaces are Flexible and Composable

## lambda expressions
- Omitting {}:a single expression
- a single expression: multiple lines of code 
- Omitting () (Single Parameter Without Type) :nly one parameter and its type is inferred by the compiler
- When () is Required: no parameters, Multiple Parameters, Explicit Type Declaration


## Important
- Lambda can use unchanged variable outside of lambda: Final Varibale, non-final variblae however never changed, Object variable










