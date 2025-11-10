package Latihan3;

   public abstract class Shape {
    // Method abstract → wajib diimplementasikan oleh subclass
    public abstract double area();

    // (Opsional) method umum untuk semua bentuk
    public void showArea() {
        System.out.println("Area: " + area());
    }
}
