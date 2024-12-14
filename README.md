# java-dumps

-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X
## Interface:

helps to achieve ABSTRATION, provides a blueprint, helps 2 systems to interact with eachother, without one system knowing details of another one.
like API(Could be developed on multiple platform but can interact with eachother as they follow a contract called REST API).
- helps in Polymorphism by supporting runtime polymorphism.
- helps in achieving Multiple inheritance
- Interfaces are meant to define a contract that is publicly accessible by all implementing classes.

- only public and default modifiers are allowed(protected and private are not allowed).
ex: public interface SampleInterface{}

- It can extend from other interfaces using "extends" keyword.
- ex: public interface SampleInterface extends Interface1, Interface2{}

- All methods are implicitly public only.
- Private allowed from Java9, Protected not allowed.

- Fields are public, static and final implicitly(CONSTANTS).
- You cannot make field private or protected.

- Overriding methods cannot have more restricted access modifiers.
- Abstract classes are not forced to override all methods.

- Default method: was introduced to add functionality to legacy classes.
- provide the implementation of default method in the interface only and can be used.
- Incase we have same default method in multiple interfaces and we are implementing them in a single class then we have to again provide the implementation in the class.
- ex: stream() was added to collection interface as a default method to avoid redundant implmentations.
- Inheritance between interfaces in case of default method present- Simple inheritance in case of no overriding or could be made abstract from default or overridden functionality with the help of child classes.


- Static methods: used to add implementation of the methods in the interface.
- it cannot be overridden by classes which implement the interface.
- can be accessed using interface name itself.
- its by default public. (till java 8 everything is public in interface)

- Private and Private static methods: (Introduced in Java 9)
- helps in adding more readability to the code.
- just remember static methods can only access static methods and non static members can access both, same is the case with above.

- Functional Interface: Interface with only one abstract method.
- Can be implemented using 1. by implementing the interface using a class 2. Using anonymous class 3. Lambda expression
- types of FI: Consumer(1->void), Supplier(void->1), Function(1->1), Predicate(1->boolean)

-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X

## Exception Handling
- Exception handling in java is used to manage unwanted exceptions gracefully. Exceptions are events which can occur during the execution of program and disrupts the prpogram flow.
- stack trace defines the path to the method where exception occured.
- Throwable class has two child classes called Error and Exception.
- Error - ex: OutOfMemoryError and StackOverFlowError
- Exception- are of two types Un-Checked/Runtime Exception and Checked/Compile-Time.
- Un-Checked/Runtime Exception- thrown during runtime and are not forced by compiler to be handled.
    ex: ClassCastException - interger value being casted to String class.
        AirthmeticException - 5/0
        IndexOutOfBoundException - accessing a index of 4 in a array of size 2. ArrayIndexOutOfBound and StringIndexOutOfBoundException
        NullPointerException - running any opertation on a null value.
        IllegalArgumentException - passing a string value in a interger expecting method. NumberFormatException
- Checked Exceptions- are forced by the compiler to be handled properly, if not compilation will fail.
    ex: ClassNotFoundException

- Ways to handle exception:
- using throws - to indicate that a particular method throws an exception, caller needs to handle it now
- try/catch block - to imply what could throw an error in try block and how to handle it in catch block.
- catch block- multiple catch blocks can be used but we can only catch what all exceptions can be thrown, or either use the super class Exception to catch them all.
- finally block- this block will always get executed, either if you return from try or catch block.Only one block is allowed ex- used mostly for loggging and end connection calls.
- throw- is used to throw a exception explicitly or rethrow a exception form the catch block. ex: throw new ClassNotFoundException


- Custom Exceptions: by extending Exception class.
ex-
public class CustomException extends Exception {
    CustomException(String message){
        super(message);
    }
}

throw new CustomException

-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X-X

## Multithreading

- Process is an instance of a program  that is getting executed. It could contain multiple threads.
- It has its own resources like memory, thread etc. OS allocated these resources to process when its created.
- Once compiled, at the time of execution JVM starts the new process


- Thread is known as lightweight process. or smallest sequence of instructions that are executed by CPU independently.
- 1 process can have multiple threads.
- When a process is created it starts with one thread this initial thread is MAIN thread and from that we can create multiple threads to perform tasks concurrently.