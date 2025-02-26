// Write a Java program to create a class called Vehicle with a method called drive(). Create a subclass called Car that overrides the drive() method to print "Repairing a car".

public class MethodOverridingWithInheritance2 {
    public static void main(String[] args) {
        Car v1 = new Car();
        v1.drive();
    }
}

class Vehicle{
    public void drive(){
        System.out.println("Driving a Vehicle");
    }
}

class Car extends Vehicle{
    @Override
    public void drive() {
        System.out.println("Driving a Car");
    }
}
