// Write a Java program to create a class called Constants with a static final variable 'PI' initialized to 3.14159. Create a method to calculate the area of a circle given its radius, using the 'PI' constant. Demonstrate the method in the main method.

public class StaticFinalVariables {
    public static double findAreaOfCircle(double radius){
        return Constants.PI*radius*radius;
    }
    public static void main(String[] args) {
        System.out.println(findAreaOfCircle(5));
    }   
}

class Constants {
    public static final double PI = 3.14159;
}