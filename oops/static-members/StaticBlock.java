// Write a Java program to create a class called "Initializer" with a static block that initializes a static variable 'initialValue' to 1000. Print the value of 'initialValue' before and after creating an instance of "Initializer"

public class StaticBlock {
    static{
        System.out.println("public class static block");
    }
    public static void main(String[] args) {
        System.out.println("Before instance creation"+" "+Initializer.initialValue);
        Initializer i1 = new Initializer();
        System.out.println("After instance creation"+" "+Initializer.initialValue);
    }    
}


class Initializer{
    public static int initialValue;

    static {
        initialValue=1000;
        System.out.println("inside block");
    }
}

