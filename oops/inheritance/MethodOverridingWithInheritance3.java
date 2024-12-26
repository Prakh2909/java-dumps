// Write a Java program to create a class called Shape with a method called getArea(). Create a subclass called Rectangle that overrides the getArea() method to calculate the area of a rectangle.

public class MethodOverridingWithInheritance3 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        System.out.println(r1.getArea(4,5));
    }
}

class Shape{
    public int getArea(int length, int breadth){
        return 0;
    }
}

class Rectangle extends Shape{
    @Override
    public int getArea(int length, int breadth) {
        return length*breadth;
    }
}
