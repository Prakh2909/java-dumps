public interface Bank {
    public void setAccountType(String accountType);
    public String getAccountType();
    public void setInterestRate(double interestRate);
    public double getInterestRate();
    public void depositMoney(int amount);
    public void withdrawMoney(int amount);
}