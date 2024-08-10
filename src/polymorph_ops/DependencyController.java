package polymorph_ops;

public class DependencyController {
    public static void main(String[] args) {
        //Demonstrate using an interface as an instance variable - have a constructor that takes in the interface as a
        //parameter. Also have a setter that allows you to update the interface object. Through code, demonstrate that you
        //understand how we can use Interfaces as dependencies (instance variables) and how useful and flexible they make our
        //application.

        IPluggable deflaultPlug = () -> System.out.println("Deflault plug connected");

        UniversalPlugin universalPlug = new UniversalPlugin(deflaultPlug);
        universalPlug.startPluggable();

        IPluggable[] ipluggables = {new USB(), new VGA(), new DVI(), new HDMI(), () -> System.out.println("GENXX connected")};

        for (IPluggable plug : ipluggables) {
            universalPlug.setPluggable(plug);
            universalPlug.startPluggable();
        }

    }
}
