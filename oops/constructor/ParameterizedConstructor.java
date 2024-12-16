// Write a Java program to create a class called Dog with instance variables name and color. Implement a parameterized constructor that takes name and color as parameters and initializes the instance variables. Print the values of the variables.

public class ParameterizedConstructor {
    public static void main(String[] args) {
        Dog d1 = new Dog("Lucy", "Black");
        System.out.println(d1.name + " " +d1.color);
    }
    
}

class Dog {
    public String name;
    public String color;

    Dog(String name, String color){
        this.name = name;
        this.color = color;
    }


}

