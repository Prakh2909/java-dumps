# java-dumps

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

## Multithreading

- Process is an instance of a program  that is getting executed. It could contain multiple threads.
- It has its own resources like memory, thread etc. OS allocated these resources to process when its created.
- Once compiled, at the time of execution JVM starts the new process


- Thread is known as lightweight process. or smallest sequence of instructions that are executed by CPU independently.
- 1 process can have multiple threads.
- When a process is created it starts with one thread this initial thread is MAIN thread and from that we can create multiple threads to perform tasks concurrently.

- To execute a code:
1. A new process is created
2. a new JVM instance is created, each JVM instance is a process.
3. Total JVM heap memory is divided into these multiple JVM instances.
4. java -Xms256m -Xmx2g MainClassName using this we can allocate minimum and maximum heap size. Exceeding this will result in OutOfMemoryError
5. Each JVM instance has a HEAP memory of its own which is shared amoung all threads of the JVM instance.
6. Register, stack, counter are local to each thread in the JVM instance and does not share each other.
7. Code Segment, Data segment is shared amoung all the threads of the JVM instance.

Heap Memory- shared by all the threads in the process. read/modified by threads, synchronization required
Code segment- contains the compiled bytecode i.e. Machine code generated using JIT compiler, it is read only.
Data segment- contains GLOBAL and STATIC variables, can be read and modified by threads, synchronization is required b/w threads.

Stack- Each thread has it own stack, manages method calls and local variables.
Register- Helps in context switching,also Used to store intermediate values, used by JIT when converting byte code to machine code to optimize machine code.
Counter- AKA program counter,points to instruction which is getting executed, increments counter after successful execution of the instruction.

Ways to create a Thread
1. By implementing Runnable interface - better if we need other class extending capabilities
2. extending Thread class - restricts to just one class being extended

Runnable interface is a functional interface that has one run() method.
Thread class also implements Runnable and has other thread associated methods.like init, sleep, notify etc..

Thread lifecycle:
New: Thread has been created but not yet started, just an object in memory.
Runnable: Thread is ready to run, waiting for CPU time.
Running: When thread start executing its code.
Blocked: this state could be because of many reasons like I/O operation, Lock acquired, Releases MONITOR LOCK.
Waiting: when we all the wait() method, makes it non runnable, goes back only if we call notify()/notifyAll(), Releases MONITOR LOCK
Timed waiting: thread waits for specific period of time and comes back to runnable state, after conditions met. like sleep(), join(). NO MONITOR LOCK released.
Terminated: Life of a thread is completed, cannot be started again.

Monitor Lock: makes sure only thread goes inside the particular section of object. a synchronized method or block. 
No matter if the its a different block or method, only one thread will acquire the lock on that object at a time.
Implementation of producer consumer problem: java-dumps\multithreading\SharedResource.java

Why Stop,Resume,Suspended method is depreciated?
STOP: Terminated the thread abruptly, No lock release, No resource cleap up happens.
SUSPENDED: Put the thread on hold for temporarily, No lock is released too.
RESUME: Used to resume the execution of Suspended thread.
Both this operation could lead to issue like Deadlock.

JOIN: When JOIN method is invoked on a thread object. Current thread will be blocked and waits for the specific thread to finish.
It is helpful when we want to coordinate between threads or to ensure we complete certain tasks before moving ahead.
Example: inside main method we have a thread th1. so we can do this to make main wait for th1 to finish. th1.join().

Thread priority: Even if we set the thread priority it does not guarantee to follow the set order. just hints the scheduler which to execute next.
Each thread inherits the priority of its parent thread. 
1=> low priority
10=> max priority
th1.setPriority()

User thread: Whatever we did above is all user thread.
Daemon thread: Daemon is something that is running async. Alive till any user thread is alive. Example: GC, Auto Save, can be used to implement Logging.
th1.setDaemon(true);

### Locking
Till now we know using syncronized we can block access to a critial method or block used by multiple thread in a single object.
But what if we need to put lock even when there are being accessed by via object.
Locking is always on object level.
This can be achived using Custom locks.

1. ReentrantLock - used when we need to allow only one thread to work on a critical code regardless if its a same object or not.
```java
// psvm
ReentrantLock lock = new ReentrantLock();
public void produce(){
    try{
        lock.lock();
        //do some work
    }catch(Exception e){
        //
    }finally{
        lock.unlock();
    }
}
```

2. ReadWriteLock
Before this we need to know what is Shared Lock and Exclusive Lock:
- if one thread has shared lock on a resource another lock can also put a shared lock which only allows READ.
- But if one thread has Exclusive lock then no other thread can either put shared or Exclusive lock on that resource as this allows READ and WRITE.

ReadLock: More than 1 thread can acquire the read lock. (Shared lock)
WriteLock: only 1 thread can acquire the write lock. (Exclusive lock)

ReadWriteLock is generally used when READ are higher than WRITE requests. as READ can be shared amoung other threads, no need to wait.

```java
// psvm
ReadWriteLock lock = new ReentrantReadWriteLock();
public void produce(){
    try{
        lock.readLock().lock();
        //do some work
    }catch(Exception e){
        //
    }finally{
        lock.readLock().unlock();
    }
}
```

3. StampedLock - it always return a stamp and validates the stamp
- provides Read write capability
- also optimistic read: it does not put a lock, rather it maintains a stamp which will be check before any operation, if its changed roll back, if not we proceed.

Passimistic lock: Whatever we have seen till stamped lock are passimistic lock
Optimistic lock: No lock is required

```java
// for read write
// long stamp = lock.writeLock(); // to put a lock
// lock.unlockWrite(stamp); // finally block

// for optimistic
// long stamp = lock.tryOptimisticRead(); // perform some operation post this
// if(lock.validate(stamp)){}
// else{}; // if any resource makes a change when this lock is acquired the value of stamp will change and this can be used to validate
// no need to release a optimistic read as this is not a lock.
```

4. Semaphore lock -  provides a additional functionality that we can control how many threads can access the resource.
Example: Connection pool where we can control number of connections to be allowed
```java
// Semaphore lock = new Semaphore(2); 
// inside try block
// lock.acquire();
// inside finally block
// lock.release();
```
//TODO: Implement examples of all the locks

Interthread communication in case of custom locks we can use Condition:
await() === wait()
signal() === notify()

```java
// ReentrantLock lock = new ReentrantLock();
// Condition condition = lock.newCondition();
// condition.await();
// condition.signal(); // .signalAll()
```


Concurrency can be achived using:
1. Lock based mechanism
2. Lock free mechanism: faster, not an alternative to 1, very specific use case
    - CAS operation(compare and swap)- same as optimistic locking but its a low level operation, meaning it is supported by CPU
    - its atomic
    - all modern processor supports it
    - involves 3 main paramters:
        1. Memory Location
        2. Expected value
        3. New value
// TODO: Continue CAS again.


