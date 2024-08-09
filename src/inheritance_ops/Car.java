package inheritance_ops;

public class Car extends Automobile {
    private int numberOfCylinders;
    private float horsepower;

    public Car(int numberOfCylinders, float horsepower, int numberOfDoors, String make, String model, int numberOfSeats) {
        super(numberOfDoors, make, model, numberOfSeats);
        this.numberOfCylinders = numberOfCylinders;
        this.horsepower = horsepower;
    }

    public Car() {}

    @Override
    public int getNumberOfDoors() {
        return super.getNumberOfDoors();
    }

    @Override
    public String getModel() {
        return  this.getClass().getSimpleName() +": XXX : " + super.getModel();
    }

    public int getNumberOfCylinders() {
        return numberOfCylinders;
    }

    public void setNumberOfCylinders(int numberOfCylinders) {
        this.numberOfCylinders = numberOfCylinders;
    }

    public float getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(float horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfCylinders=" + numberOfCylinders +
                ", horsepower=" + horsepower +
                '}';
    }
}
