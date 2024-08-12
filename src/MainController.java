public class MainController {
    public static void main(String[] args) {
        Engine engine = new Engine(5737);
        Cockpit cockpit = new Cockpit(2);
        Wings wings = new Wings("Aileron");
        Fuselage fuselage = new Fuselage(494999);

        Airplane plane = new Airplane(4533.74, 4505,engine, cockpit, wings, fuselage);

        System.out.println(plane);
    }
}
