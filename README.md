Inheritance
Tugas Pemrograman Berorientasi Objek – Inheritance
Repositori ini dibuat untuk latihan Inheritance di Java, termasuk pemahaman tentang subclass, superclass, method overriding, dan polymorphism,
berisi latihan penerapan konsep Inheritance (pewarisan) dalam Java.
Contohnya termasuk class Vehicle dengan subclass Car dan Motorcycle, serta class Account dengan subclass SavingsAccount dan CheckingAccount.
Tujuannya untuk memahami bagaimana subclass mewarisi atribut dan method dari superclass, serta bagaimana polymorphism dan method overriding bekerja.
//Latihan
Kerjakan latihan di editor/IDE kamu. Setelah selesai, coba compile & jalankan.

Latihan 1, Kendaraan
Buat class Vehicle { String brand; void start() { System.out.println("vehicle starts"); } }
Buat Car extends Vehicle dan Motorcycle extends Vehicle dengan override start() masing-masing.
Buat main yang membuat array Vehicle[] berisi mobil & motor lalu panggil start() pada tiap elemen.
Latihan 2, Bank (inheritance + casting)
class Account { String accNo; double balance; ... }
class SavingsAccount extends Account { double interestRate; void addInterest() { balance += balance * interestRate; } }
class CheckingAccount extends Account { double overdraftLimit; }
Buat list Account[], isi beberapa SavingsAccount dan CheckingAccount. Iterasi: jika item instanceof SavingsAccount, cast lalu panggil addInterest().
Latihan 3, Shape dengan abstrak
Buat abstract Shape dengan abstract double area() dan buat Triangle, Rectangle, Circle. Buat program yang menghitung total area dari daftar shape.

//Source Code
//Latihan Kendaraan//
--Latihan 1--
--Vehicle--

package Latihan1;

public class Vehicle {
    String brand;

    void start() {
        System.out.println("vehicle starts");
    }
}

--Car--

package Latihan1;

    public class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("car starts with key ignition");
    }
}

--Motorcycle--

package Latihan1;

    public class Motorcycle extends Vehicle {
    @Override
    void start() {
        System.out.println("motorcycle starts with button");
    }
}

--Main--

package Latihan1;

    public class Main {
    public static void main(String[] args) {
        // Membuat array Vehicle yang berisi berbagai jenis kendaraan
        Vehicle[] vehicles = new Vehicle[3];

        // Mengisi array dengan objek Car dan Motorcycle
        vehicles[0] = new Vehicle();
        vehicles[1] = new Car();
        vehicles[2] = new Motorcycle();

        // Memanggil start() pada tiap elemen array
        for (Vehicle v : vehicles) {
            v.start();  // polymorphism: panggil sesuai tipe objek sebenarnya
        }
    }
}

--Latihan 2--
--Account--

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

--SavingsAccount--

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

--CheckingAccount--

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

--Main--

package Latihan2;

   public class Main {
    public static void main(String[] args) {
        // Membuat array berisi berbagai tipe akun (polymorphism)
        Account[] accounts = new Account[4];
        accounts[0] = new SavingsAccount("SA001", 1000, 0.05);
        accounts[1] = new CheckingAccount("CA001", 2000, 500);
        accounts[2] = new SavingsAccount("SA002", 1500, 0.03);
        accounts[3] = new CheckingAccount("CA002", 2500, 1000);

        // Iterasi semua akun
        for (Account acc : accounts) {
            acc.showInfo(); // panggil versi masing-masing (override)

            // Jika akun adalah SavingsAccount, tambahkan bunga
            if (acc instanceof SavingsAccount) {
                SavingsAccount sa = (SavingsAccount) acc; // casting
                sa.addInterest(); // panggil method khusus SavingsAccount
            }
        }

        System.out.println("\n=== Setelah bunga ditambahkan pada akun tabungan ===");
        for (Account acc : accounts) {
            acc.showInfo();
        }
    }
}

--Latihan 3--
--Shape--

package Latihan3;

   public abstract class Shape {
    // Method abstract → wajib diimplementasikan oleh subclass
    public abstract double area();

    // (Opsional) method umum untuk semua bentuk
    public void showArea() {
        System.out.println("Area: " + area());
    }
}

--Triangle--

package Latihan3;

    public class Triangle extends Shape {
    double base;
    double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

--Rectangle--

package Latihan3;

    public class Rectangle extends Shape {
    double width;
    double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

--Circle--

package Latihan3;

    public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

--Main--

package Latihan3;

    public class Main {
    public static void main(String[] args) {
        // Membuat array dari berbagai bentuk (polymorphism)
        Shape[] shapes = {
            new Triangle(10, 5),
            new Rectangle(4, 6),
            new Circle(3)
        };

        double totalArea = 0;

        // Iterasi semua shape dan hitung total area
        for (Shape s : shapes) {
            System.out.println(s.getClass().getSimpleName() + " area = " + s.area());
            totalArea += s.area();
        }

        System.out.println("----------------------");
        System.out.println("Total area = " + totalArea);
    }
}

Tugas ini telah menunjukkan penerapan konsep Inheritance dalam Java. Semua contoh telah diuji dan siap dijadikan referensi untuk latihan OOP lanjutan.
Dengan latihan ini, saya dapat memahami penerapan Inheritance dalam Java secara praktis, termasuk konsep subclass, superclass, method overriding, dan polymorphism. Proyek ini menjadi dasar yang kuat untuk mempelajari konsep OOP lainnya dan membangun program Java yang modular dan mudah dipelihara.
