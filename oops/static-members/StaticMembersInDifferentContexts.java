// Write a Java program to create a class called "BankAccount" with instance variables 'accountNumber' and balance, and static variables 'bankName' and 'interestRate'. Provide static methods to get and set the static variables. Create several 'BankAccount' objects and print their details along with the static variables.

public class StaticMembersInDifferentContexts {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        BankAccount.setBankName("Canara Bank");
        BankAccount.setInterestRate(2.3f);

        System.out.println(BankAccount.getBankName());
        System.out.println(BankAccount.getInterestRate());
    }
}

class BankAccount{
    public String accountNumber;
    public String balance;
    public static String bankName;
    public static float interestRate;

    public static String getBankName(){
        return BankAccount.bankName;
    }

    public static void setBankName(String bankName){
        BankAccount.bankName = bankName;
    }

    public static float getInterestRate(){
        return BankAccount.interestRate;
    }

    public static void setInterestRate(float interestRate){
        BankAccount.interestRate = interestRate;
    }
}
