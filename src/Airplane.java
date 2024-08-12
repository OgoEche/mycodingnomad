public class Airplane {
    private double fuelCapacity;
    private int currentFuelLevel;

    Engine engine;
    Cockpit cockpit;
    Wings wings;
    Fuselage fuselage;

    public Airplane(double fuelCapacity, int currentFuelLevel, Engine engine, Cockpit cockpit, Wings wings, Fuselage fuselage) {
        this.fuelCapacity = fuelCapacity;
        this.currentFuelLevel = currentFuelLevel;
        this.engine = engine;
        this.cockpit = cockpit;
        this.wings = wings;
        this.fuselage = fuselage;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "fuelCapacity=" + fuelCapacity +
                ", currentFuelLevel=" + currentFuelLevel +
                ", engine=" + engine +
                ", cockpit=" + cockpit +
                ", wings=" + wings +
                ", fuselage=" + fuselage +
                '}';
    }
}
