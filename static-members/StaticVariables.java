// Write a Java program to create a class called "Counter" with a static variable count. Implement a constructor that increments count every time an object is created. Print the value of count after creating several objects.

public class StaticVariables {
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter("John");
        Counter c3 = new Counter();
        Counter c4 = new Counter("Pete");
        System.out.println(Counter.totalCount);
    }
}

class Counter{
    public static int totalCount;
    public String name;
    Counter(){
        totalCount++;
    }
    Counter(String name){
        this();
        this.name=name;
    }
}

