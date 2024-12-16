// Write a Java program to create a class called "ComplexInitializer" with a static block that initializes multiple static variables (x, y, z) using complex logic. Print the values of these variables in the main method.

public class StaticBlockforComplexInitialization {
    public static void main(String[] args) {
        System.out.println(ComplexInitializer.x);
        System.out.println(ComplexInitializer.y);
        System.out.println(ComplexInitializer.z);
    }    
}

class ComplexInitializer{
    public static int x,y,z;
    static{
        x = 10;
        y = 20;
        z = calculateZ(x, y);
    }

    public static int calculateZ(int x, int y){
        return x+y+32;
    }
}