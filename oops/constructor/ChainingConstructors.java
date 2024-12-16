// Write a Java program to create a class called Student with instance variables studentId, studentName, and grade. Implement a default constructor and a parameterized constructor that takes all three instance variables. Use constructor chaining to initialize the variables. Print the values of the variables.

public class ChainingConstructors {
    public static void main(String[] args) {
        Student s1 = new Student(001,"JohnDoe",'A');
        System.out.println(s1.grade);
        System.out.println(s1.studentId);
        System.out.println(s1.studentName);
    }    
}

class Student{
    public int studentId;
    public String studentName;
    public char grade;

    Student(){
        this(0,"Unknown",'Z');
    }
    Student(int studentId, String studentName, char grade){
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }

}
