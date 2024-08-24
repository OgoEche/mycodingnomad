package enumeration_ops;

// Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
// of this enum from a separate class.
public class EnumVehicleController {

    public static void main(String[] args) {
        for (var vehicle : Vehicle.values()) {
            System.out.println(vehicle);
        }
    }
}
