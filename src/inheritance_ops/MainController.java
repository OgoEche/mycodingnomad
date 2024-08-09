package inheritance_ops;

public class MainController {
    public static void main(String[] args) {
        Vehicle vehicle = new Car(6,45.7f, 5, "Volvo","XC90", 7);
        Car car = new Car(5,40.7f, 5, "Kia","EV9", 6);
        Vehicle vehicle2 = new Vehicle("Audio", "XXxXX", 4);
        System.out.println(vehicle);
        System.out.println(car);
        System.out.println(car.getModel());
        System.out.println(vehicle.getModel());
        System.out.println(vehicle2);
    }
}
