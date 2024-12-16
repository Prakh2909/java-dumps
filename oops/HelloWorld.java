public class HelloWorld {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println(p1);
    }
}

class Person {

    Person(){

    }

    Person(int x){
        System.out.println("Person x");
    }
}

class Manager extends Person {
    Manager(){
        System.out.println("Manager class");
    }

    Manager(int x){
        System.out.println("Manager x");
    }
}
