package Latihan2;
public class Account {
    String accNo;
    double balance;

    public Account(String accNo, double balance) {
        this.accNo = accNo;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println(accNo + ": Deposit " + amount + ", balance = " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(accNo + ": Withdraw " + amount + ", balance = " + balance);
        } else {
            System.out.println(accNo + ": Insufficient balance!");
        }
    }

    void showInfo() {
        System.out.println("Account [" + accNo + "] balance = " + balance);
    }
}
