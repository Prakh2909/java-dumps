// Write a Java program to create a class called Classroom with instance variables className and students (an array of strings). Implement a parameterized constructor that initializes these variables. Print the values of the variables.

import java.util.Arrays;

public class ConstructorwithArrayInitialization {
    public static void main(String[] args) {
        String[] students = {"name1","name2","name3"};
        Classroom c1 = new Classroom("Mathametics", students);
        System.out.println(Arrays.toString(c1.students));
        students[1] = "Name5";
        System.out.println(Arrays.toString(c1.students));
        
    }
}

class Classroom {
    public String className;
    public String[] students;

    Classroom(String className, String[] students){
        this.className = className;
        this.students = students.clone();
    }
}
