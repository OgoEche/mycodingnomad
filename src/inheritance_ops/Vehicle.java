package inheritance_ops;

public class Vehicle {
    private String make;
    private String model;
    private int numberOfSeats;

    public Vehicle(String make, String model, int numberOfSeats) {
        this.make = make;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
    }

    public Vehicle() {
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                '}';
    }
}
