// Write a Java program to create a class called "Cat" with instance variables name and age. Implement a default constructor that initializes the name to "Unknown" and the age to 0. Print the values of the variables.


public class DefaultConstructor {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        System.out.println(c1.name);
        System.out.println(c1.age);
    }
}

class Cat {
    public String name;
    public int age;

    Cat(){
        this.name = "Unknown";
        this.age = 0;
    }
}