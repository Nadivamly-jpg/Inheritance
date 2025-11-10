package Latihan2;

    public class CheckingAccount extends Account {
    double overdraftLimit; // batas saldo minus

    public CheckingAccount(String accNo, double balance, double overdraftLimit) {
        super(accNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(accNo + ": Withdraw " + amount + ", new balance = " + balance);
        } else {
            System.out.println(accNo + ": Overdraft limit exceeded!");
        }
    }

    @Override
    void showInfo() {
        System.out.println("CheckingAccount [" + accNo + "] balance = " + balance + ", overdraft limit = " + overdraftLimit);
    }
}
