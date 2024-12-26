// Write a Java program to create a class called Animal with a method called makeSound(). Create a subclass called Cat that overrides the makeSound() method to bark.


public class MethodOverridingWithInheritance1 {
    public static void main(String[] args) {
        Dog a1 = new Dog();
        a1.makeSound();
        a1.legs();
    }    
}

abstract class Animal{
    public abstract void makeSound();
}

class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    public void legs(){
        System.out.println("4");
    }
}


