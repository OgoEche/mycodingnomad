package inheritance_ops;

public class Automobile extends Vehicle {
    private int numberOfDoors;

    public Automobile(int numberOfDoors, String make, String model, int numberOfSeats) {
        super(make, model, numberOfSeats);
        this.numberOfDoors = numberOfDoors;
    }

    public Automobile() {}

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "numberOfDoors=" + numberOfDoors +
                '}';
    }
}
