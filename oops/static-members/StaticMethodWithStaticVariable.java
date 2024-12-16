// Write a Java program to create a class called "IDGenerator" with a static variable 'nextID' and a static method "generateID()" that returns the next ID and increments 'nextID'. Demonstrate the usage of generateID in the main method.

public class StaticMethodWithStaticVariable {
    public static void main(String[] args) {
        System.out.println(IDGenerator.generateID());
        System.out.println(IDGenerator.generateID());
        System.out.println(IDGenerator.generateID());
        System.out.println(IDGenerator.generateID());
    }
}

class IDGenerator{
    public static int nextID=5001;
    
    public static int generateID(){
        int tempID = nextID;
        nextID++;
        return tempID;
    }
}
