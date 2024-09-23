# Java Basic

## JDK vs JRE vs JVM

**JVM**: Java Virtual Machine is an abstract machine that provides a runtime environment to execute Java bytecode. It converts the bytecode into machine-specific code, allowing Java programs to run on any platform that has a JVM
**JRE**: Java Runtime Environment is a software package that provides libraries, the JVM, and other components necessary for running Java applications
**JDK**: Java Development Kit is a full software development kit that includes everything in the JRE plus additional tools for developing, compiling, and debugging Java applications


## Final:
- Immutability: Declaring variables as final ensures that their values won't change
- Security: Using final methods or classes can prevent unintended modifications or extensions, increasing the security of the code
- Performance: in some cases, making method as final can give the JVM the opportunity to optimize them since the method's behavior is known at the compile time

## Static:
- **Static Variable**:
  - Shared among all instances
  - Useful for constants or data that should be consistent across all instances of the class
- **Static Methods**:
  - Can be called without creating an object
- **Static Block**:
  - Used for initializing static varibales or running onde when the class is loaded
- **Static Nested Classes**:
  - Useful when the nested class is logically associatedd with the outer class but does not need access to instance members of the outer class

## Encapsulation:
- Getter/Setter

## Aceess Modifiers:
- Default: Within the package
- Private: Within the class
- Protected: Within the package or all subclasses
- Public: everywhere


## Polymorphism:
- Static Polymorphism:
  - Overload:
  - Same class
  - Different Arguments
- Dynamic Polymorphism:
  - Override:
  - Same Arguments
  - Base and Derived class are required


## Abstract classes
- abstract
  - Non-abstract class cannot have abstract methods
  - Cannot be declared private
  - Cannot be instantiated
  - Child classes must implement all the abstract methods
  - abstract method: no body
- interface:
  - abstract method: no body
  - default method
  - static method
  - No fields
  - multiple inheritance
  - 