// Write a Java program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:

// One constructor takes title and author as parameters.
// The other constructor takes title, author, and price as parameters.
// Print the values of the variables for each constructor.

class Book {
    public String title;
    public String author;
    public String price;
    
    Book(){
        this("Unknown","Unknown","Unknown");
    }

    Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    
    Book(String title, String author, String price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class ConstructorOverloading {

    public static void main(String[] args) {
        Book b1 = new Book("Tales of the sea","John Sharma");
        Book b2 = new Book("Landing tales","John Shukla","14.99$");
        System.out.println(b1.author+" "+b1.title);
        System.out.println(b2.author+" "+b2.title+" "+b2.price);
    }    
}


