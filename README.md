# java-dumps

## Java Topic and notes link
- [OOPS Concepts](https://drive.google.com/file/d/1eg_I2kdII2_KPtzGifky-YEvFcgaCX4H/view?usp=drive_link)
- [JDK, JRE, JVM](https://drive.google.com/file/d/1orNECv5ucicgyhcC58tsQ10lTqj0Xc0K/view?usp=drive_link)
- [Primitive Variables](https://drive.google.com/file/d/1vWVJ9nAIbih0vier0XD-jFaUCujWuYnU/view?usp=drive_link)
- [Non-Primitive Variables](https://drive.google.com/file/d/1y23GVqAKPxQ72ZAP1_uOsJW2XfnBDhX5/view?usp=drive_link)
- [Methods](https://drive.google.com/file/d/1KEMCFaA5phnL1qneiWPPsSeDGoRqFyWK/view?usp=drive_link)
- [Memory Management](https://drive.google.com/file/d/1VLbaVl69r9FlKw2q_nI4qS6mlGx1t9Js/view?usp=drive_link)
- [Classes1](https://drive.google.com/file/d/1eE5Pculcp0qem6tMPHDz9h-jhMclzGIt/view?usp=drive_link)
- [Classes2](https://drive.google.com/file/d/1MplD0GcXSgk1qCGQ7NFx4tWh8LDP_HtK/view?usp=drive_link)

## Interface:
- helps to achieve ABSTRATION, provides a blueprint, helps 2 systems to interact with eachother, without one system knowing details of another one.
- like API(Could be developed on multiple platform but can interact with eachother as they follow a contract called REST API).
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

### Default method: 
- was introduced to add functionality to legacy classes.
- provide the implementation of default method in the interface only and can be used.
- Incase we have same default method in multiple interfaces and we are implementing them in a single class then we have to again provide the implementation in the class.
- ex: stream() was added to collection interface as a default method to avoid redundant implmentations.
- Inheritance between interfaces in case of default method present- Simple inheritance in case of no overriding or could be made abstract from default or overridden functionality with the help of child classes.

### Static methods
- used to add implementation of the methods in the interface.
- it cannot be overridden by classes which implement the interface.
- can be accessed using interface name itself.
- its by default public. 

Note : (till java 8 everything is public in interface)

### Private and Private static methods: (Introduced in Java 9)
- helps in adding more readability to the code.
- just remember static methods can only access static methods and non static members can access both, same is the case with above.

### Functional Interface
- Interface with only one abstract method.
- Can be implemented using
    1. by implementing the interface using a class 
    2. Using anonymous class 
    3. Lambda expression
- Types of FI: 
    1. Consumer - Takes one argument and returns nothing
    2. Supplier - Takes no argument and returns something
    3. Function - Takes argument and returns something
    4. Predicate - Takes arguments an return in Boolean


## Exception Handling
- Exception handling in java is used to manage unwanted exceptions gracefully. Exceptions are events which can occur during the execution of program and disrupts the prpogram flow.
- stack trace defines the path to the method where exception occured.
- Throwable class has two child classes called 
    1. Error - ex: OutOfMemoryError and StackOverFlowError
    2. Exception
        1. Un-Checked/Runtime Exception- thrown during runtime and are not forced by compiler to be handled. Example below:
            - ClassCastException - interger value being casted to String class.
            - AirthmeticException - 5/0
            - IndexOutOfBoundException - accessing a index of 4 in a array of size 2.
            - ArrayIndexOutOfBound and StringIndexOutOfBoundException
            - NullPointerException - running any opertation on a null value.
            - IllegalArgumentException - passing a string value in a interger expecting method
            - NumberFormatException
        2. Checked/Compile-Time Exceptions- are forced by the compiler to be handled properly, if not compilation will fail.
            - ClassNotFoundException

### How to handle exception:
- Using throws - to indicate that a particular method throws an exception, caller needs to handle it now
- try/catch block - to imply what could throw an error in try block and how to handle it in catch block.
- catch block- multiple catch blocks can be used but we can only catch what all exceptions can be thrown, or either use the super class Exception to catch them all.
- finally block- this block will always get executed, either if you return from try or catch block. Only one block is allowed ex- used mostly for loggging and end connection calls.
- throw- is used to throw a exception explicitly or rethrow a exception form the catch block. ex: throw new ClassNotFoundException


### Custom Exceptions 
- by extending Exception class.
```java
public class CustomException extends Exception {
    CustomException(String message){
        super(message);
    }
    
}
// throw new CustomException  => use this to throw exception
```

## Multithreading

- Process is an instance of a program  that is getting executed. It could contain multiple threads.
- It has its own resources like memory, thread etc. OS allocated these resources to process when its created.
- Once compiled, at the time of execution JVM starts a new process.

### Thread
- Thread is known as lightweight process. or smallest sequence of instructions that are executed by CPU independently.
- 1 process can have multiple threads.
- When a process is created it starts with one thread this initial thread is MAIN thread and from that we can create multiple threads to perform tasks concurrently.

### To execute a code
- A new process is created
- a new JVM instance is created, each JVM instance is a process.
- Total JVM heap memory is divided into these multiple JVM instances.
- java -Xms256m -Xmx2g MainClassName using this we can allocate minimum and maximum heap size. Exceeding this will result in OutOfMemoryError


### JVM instance

![alt text](images/jvm.png)
- Each JVM instance has a HEAP memory of its own which is shared amoung all threads of the JVM instance.
-  Register, stack, counter are local to each thread in the JVM instance and does not share each other.
- Code Segment, Data segment is shared amoung all the threads of the JVM instance.

- Heap Memory- shared by all the threads in the process. read/modified by threads, synchronization required
- Code segment- contains the compiled bytecode i.e. Machine code generated using JIT compiler, it is read only.
- Data segment- contains GLOBAL and STATIC variables, can be read and modified by threads, synchronization is required b/w threads.

- Stack- Each thread has it own stack, manages method calls and local variables.
- Register- Helps in context switching,also Used to store intermediate values, used by JIT when converting byte code to machine code to optimize machine code.
- Counter- AKA program counter, points to instruction which is getting executed, increments counter after successful execution of the instruction.

### Ways to create a Thread
1. By implementing Runnable interface - better if we need other class extending capabilities
2. extending Thread class - restricts to just one class being extended
```java
public class MultiThreadingExample{
    public static void main(String[] args) {
        Runnable r1 = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        Thread t1 = new Thread(r1);
        t1.start();
        Runnable r2 = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread t2 = new Thread(r2);
        t2.start();

        Thread t3 = new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" using Lambda function");
        });
        t3.start();

    }
}
```
- Runnable interface is a functional interface that has one run() method.
- Thread class also implements Runnable and has other thread associated methods.like init, sleep, notify etc..

### Thread lifecycle:

![alt text](images/thread-lifecycle.png)

- New: Thread has been created but not yet started, just an object in memory.
- Runnable: Thread is ready to run, waiting for CPU time.
- Running: When thread start executing its code.
- Blocked: this state could be because of many reasons like I/O operation, Lock acquired, Releases MONITOR LOCK.
- Waiting: when we all the wait() method, makes it non runnable, goes back only if we call notify()/notifyAll(), Releases MONITOR LOCK
- Timed waiting: thread waits for specific period of time and comes back to runnable state, after conditions met. like sleep(), join(). NO MONITOR LOCK released.
- Terminated: Life of a thread is completed, cannot be started again.

### Monitor Lock
- makes sure only thread goes inside the particular section of object. a synchronized method or block. 
- No matter if the its a different block or method, only one thread will acquire the lock on that object at a time.

Note: 
Implementation of producer consumer problem: 
java-dumps\multithreading\SharedResource.java

### Why Stop,Resume,Suspended method is depreciated?
- STOP: Terminated the thread abruptly, No lock release, No resource cleap up happens.
- SUSPENDED: Put the thread on hold for temporarily, No lock is released too.
- RESUME: Used to resume the execution of Suspended thread.

Both this operation could lead to issue like Deadlock.

### Thread Joining
- JOIN: When JOIN method is invoked on a thread object. Current thread will be blocked and waits for the specific thread to finish.
- It is helpful when we want to coordinate between threads or to ensure we complete certain tasks before moving ahead.
- Example: inside main method we have a thread th1. so we can do this to make main wait for th1 to finish. th1.join().

### Thread Priority
- Thread priority: Even if we set the thread priority it does not guarantee to follow the set order. just hints the scheduler which to execute next.
- Each thread inherits the priority of its parent thread. 
- 1=> low priority
- 10=> max priority
- th1.setPriority()

### Daemon thread
- Daemon thread: Daemon is something that is running async. Alive till any user thread is alive. 
- Example: GC, Auto Save, can be used to implement Logging.
- th1.setDaemon(true);

## Locking
- Till now we know using syncronized we can block access to a critial method or block used by multiple thread in a single object.
- But what if we need to put lock even when there are being accessed by via object.
- Locking is always on object level.

### Reentrant Lock 
- used when we need to allow only one thread to work on a critical code regardless if its a same object or not.

![alt text](images/reentrant-lock.png)

### ReadWriteLock
- Before this we need to know what is Shared Lock and Exclusive Lock:
- if one thread has shared lock on a resource another thread can also put a shared lock which only allows READ.
- But if one thread has Exclusive lock then no other thread can either put shared or Exclusive lock on that resource as this allows READ and WRITE.

ReadLock 
- More than 1 thread can acquire the read lock. (Shared lock)

WriteLock
- only 1 thread can acquire the write lock. (Exclusive lock)

ReadWriteLock is generally used when READ are higher than WRITE requests. as READ can be shared amoung other threads, no need to wait.

![alt text](images/read-write-lock.png)

### StampedLock 
- it always return a stamp and validates the stamp
- provides Read write capability as well

Optimistic read: it does not put a lock, rather it maintains a stamp which will be check before any operation, if its changed roll back, if not we proceed.

Passimistic lock: ReadWrite Lock and Reentrant Locks.

Optimistic lock: When No lock is required

1. Provides Read Write functionality

![alt text](images/stamped-read-write.png)

2. Provides Optimistic locking

![alt text](images/stamped-optimistic-lock.png)

### Semaphore lock 
- provides a additional functionality that we can control how many threads can access the resource.

![alt text](images/semaphore-lock.png)

TODO: Implement examples of all the locks


### Interthread communication
- we can only use wait and notify methods with Monitor locks for interthread communication.
- Incase of custom locks we need to use await and signal for interthread communication

```java
// ReentrantLock lock = new ReentrantLock();
// Condition condition = lock.newCondition();
// condition.await();
// condition.signal(); // .signalAll()
```


### Concurrency can be achived using:
1. Lock based mechanism (Passimistic Locking and Optimistic Locking)
2. Lock free mechanism: faster, not an alternative to 1, very specific use case
    - CAS operation(compare and swap)- same as optimistic locking but its a low level operation, meaning it is supported by CPU
    - its atomic
    - all modern processor supports it
    - involves 3 main paramters:
        1. Memory Location
        2. Expected value
        3. New value

## Lock Free concurrency
- C-A-S (COmpare and Swap) technique helps in achieving Lock free concurrency.
    - Its a low level operation, supported by CPU.
    - Its atomic, not dependenct on cores and all modern processors supports this.
    - Its used only when we have a scenario where we are doing READ, MODIFY and UPDATE
    - It involves 3 main parameters:
        1. Memory location - location where the variable is stored
        2. Expected Value - value which should be present at that memory
        3. New Value - Value to be written to the memory, if the expected value is same as the value present at that memory.
    - similar to optimistic locking, inspired from CAS
    - ABA problem: suppose a value is changed from A to B and then changed back to A, what will happen in that case. for this we can use one more parameter to compare i.e. versioning or timestamp.

### Atomic variables
- helps in achieving CAS.
- means single or "All or nothing"
- Atomic operation is when a operation is same for each and every thread
    - Example: int a = 10; // this here is same for all the threads.
    - but count = count+1 when used with two threads might not give the expected results.
- How to handle it then?
    1. Using lock like synchronized
    2. Using lock free operation like AtomicInteger, AtomicBoolean, AtomicLong, AtomicReference
        - internally Atomic Integer uses volatile and CAS operations to achieve this.
![alt text](images/cas.png)

## Thread Pool and Thread pool Executor
[Notes](https://notebook.zohopublic.in/public/notes/74tdo0e297bb7d6dd4d45a837d13f60fedc3f)
 




TODO: Generic classes

## Java Collection
- introducted in java 1.2
- represents a group of objects. Its an interface which provides methods to work on group of objects.

Mentioned below are the most commonly used methods which are implemented by child classes like ArrayList, LinkedList etc
    1.  size()
    2.  isEmpty()
    3.  contains()
    4.  toArray()
    5.  add()
    6.  remove()
    7.  addAll()
    8.  removeAll()
    9.  clear()
    10. equals()

### Collection vs Collections
- Collection is a part of Java Collection Framework
- Collections is a Utility class which provides static methods used to operate on Collections. 

### Iterable
- used to traverse collections

```java
List<Integer> values = new ArrayList<>();
values.add(1);
values.add(2);
values.add(3);
values.add(4);
values.add(5);


System.out.println("Using iterator");
Iterator<Integer> iterator = values.iterator();

while(iterator.hasNext()){
    int value = iterator.next();
    System.out.println(value);
    if(value==3){
        iterator.remove();
    }
}

```

### Comparator vs Comparable
- Both provides a way to sort the objects.
- Comparable: It defines natural ordering within the class. compareTo(). Natural order sorting
- Comparator: It defines external sorting logic. compare(). Custom sorting

### Thread safe alternatives
- Priority Queue => PriorityBlockingQueue
- ArrayDeque => ConcurrentLinkedDeque
- ArrayList => CopyOnWriteArrayList
- LinkedList => CopyOnWriteArrayList
- Vector - same as ArrayList, Already threadsafe
- Stack - threadsafe already as this is a child of Vector
- HashMap - HashTable (synchronised version of HashMap), ConcurrentHashMap
- LinkedHashMap - Not thread safe, we have to make it thread safe manually
- HashSet - We can use new ConcurrentHashMap.newKeySet() to create the set thread safe

![alt text](images/concurrent-collection.png)

### LinkedHashMap
- Same as HashMap
- Maintains insertion order or Maintains Access order (Uses doubly LinkedList for both )

### Vector
- Same as ArrayList, Threadsafe.
- Puts lock when operations are being performed
- Less efficient then ArrayList as for each operation it do lock/unlock internally.
### Queue
- Queue is an interface of Collections.
- add()* - Inserts the element into the queue. True if insertion is sucess and Exception if insertion fails. Null is not allowed.
- offer() - Inserts the element into the queue. True if insertion is sucess and False if insertion fails. Null is not allowed.
- remove()* - Retrieves and Removes the head of the queue. Returns Exception(NoSuchElementException) if Queue is Empty.
- poll() - Retrieves and Removes the head of the queue. Returns Null if Queue is Empty.
- peek() - Retrieves the value present at the head of the queue but do not remove it.Null if queue is empty.
- element()* - Retrieves the value present at the head of the queue but do not remove it. Returns an exception(NoSuchElementException) if queue is empty.