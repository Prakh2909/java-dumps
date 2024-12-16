// Write a Java program to create a class called "MathUtility" with a static method add that takes two integers and returns their sum. Demonstrate the usage of this static method in the main method without creating an instance of "MathUtility".

public class StaticMethods {
    public static void main(String[] args) {
        System.out.println(MathUtility.getSum(2, 3));

        System.out.println(MathUtility.getSum(9, 5));
    }
}

class MathUtility {
    public static int getSum(int num1, int num2){
        return num1+num2;
    }
}