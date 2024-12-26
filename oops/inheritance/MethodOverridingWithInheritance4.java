// Write a Java program to create a class called Employee with methods called work() and getSalary(). Create a subclass called HRManager that overrides the work() method and adds a new method called addEmployee().

public class MethodOverridingWithInheritance4 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.work();
        HRManager hm1 = new HRManager();
        hm1.work();
    }
}

class Employee{
    public int salary;
    public void work(){
        System.out.println("Employee");
    }

    public int getSalary(){
        return this.salary;
    }
}

class HRManager extends Employee{

    @Override
    public void work() {
        System.out.println("HRManager");
    }

    public void addEmployee(){
        System.out.println("Employee Added");
    }
}
