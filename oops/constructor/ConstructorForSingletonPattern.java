// Write a Java program to create a class called Singleton that ensures only one instance of the class can be created. Implement a private constructor and a public static method to get the single instance of the class. Print a message indicating the creation of the instance.

public class ConstructorForSingletonPattern {
    public static void main(String[] args) {
        
    }
}

class Singleton{
    private static volatile Singleton instance;
    private Singleton(){
        System.out.println("Singleton instance created");
    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
