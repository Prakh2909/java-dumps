// Write a Java program to create a class called Rectangle with instance variables length and width. Implement a parameterized constructor and a copy constructor that initializes a new object using the values of an existing object. Print the values of the variables.

public class CopyConstructor {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(28.3, 25.2);
        Rectangle r2 = new Rectangle(r1);
        
        System.out.println(r1.length+" "+r1.width);
        System.out.println(r2.length+" "+r2.width);
    }
}

class Rectangle {
    public double length;
    public double width;

    Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    Rectangle(Rectangle rectangle){
        this.length = rectangle.length;
        this.width = rectangle.width;
    }
}


