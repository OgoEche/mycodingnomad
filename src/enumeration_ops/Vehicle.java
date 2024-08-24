package enumeration_ops;

public enum Vehicle {

    CAR(4,"Hybrid Electric", "Volvo XC90"),
    TRUCK(6,"Freightliner", "Tanker"),
    MOTORCYCLE(2, "Scooter", "Yamaha TMAX" ),
    PLANE(3,"Jet Fighter","F16"),
    BOAT(0, "Yacht","Sailing");

    private final Integer numberOfWheel;
    private final String engineType;
    private final String typeName;

    private Vehicle(int numberOfWheel, String engineType, String typeName) {
        this.numberOfWheel = numberOfWheel;
        this.engineType = engineType;
        this.typeName = typeName;
    }

    public int getNumberOfWheel() {
        return numberOfWheel;
    }

    public String getEngineType() {
        return engineType;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type =" + this.name() +
                ", numberOfWheel=" + numberOfWheel + '\'' +
                ", engineType='" + engineType + '\'' +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
