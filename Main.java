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

