package Latihan2;

    public class SavingsAccount extends Account {
    double interestRate; // contoh: 0.05 = 5%

    public SavingsAccount(String accNo, double balance, double interestRate) {
        super(accNo, balance);
        this.interestRate = interestRate;
    }

    void addInterest() {
        balance += balance * interestRate;
        System.out.println(accNo + ": Interest added, new balance = " + balance);
    }

    @Override
    void showInfo() {
        System.out.println("SavingsAccount [" + accNo + "] balance = " + balance + ", rate = " + (interestRate * 100) + "%");
    }
}

