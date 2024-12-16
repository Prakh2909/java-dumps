// Write a Java program to create a class called Car with instance variables make, model, and year. Implement a parameterized constructor that initializes these variables and assigns default values if not provided. Print the values of the variables.

public class ConstructorWithDefaultValues {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1.make+" "+c1.model+" "+c1.year);
    }
}

class Car {
    public String make;
    public String model;
    public int year;

    Car(){
        this("","",0);
    }

    Car(String make, String model, int year){
        this.make = (make == null || make.isEmpty())? "Unknown make":make;

        this.model = (model == null || model.isEmpty())? "Unknown model":model;

        this.year = (year<=0)? 2000:year;
    }
}