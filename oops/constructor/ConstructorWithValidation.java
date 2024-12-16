// Write a Java program to create a class called Account with instance variables accountNumber and balance. Implement a parameterized constructor that initializes these variables with validation:

// accountNumber should be non-null and non-empty.
// balance should be non-negative.
// Print an error message if the validation fails.

import java.util.Objects;

public class ConstructorWithValidation {
    public static void main(String[] args) {
        Account a1 = new Account("112112", -1);
    }
}

class Account {
    public String accountNumber;
    public long balance;

    Account(String accountNumber, long balance){
        if(Objects.isNull(accountNumber) || accountNumber.isBlank()){
            System.out.println("Please enter a valid account number");
            return;
        }

        if(Objects.isNull(balance) || balance < 0){
            System.out.println("Please enter a valid Bank balance");
            return;
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}


