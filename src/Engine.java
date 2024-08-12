public class Engine {
    private double horsePower;

    public Engine(double horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "horsePower=" + horsePower +
                '}';
    }
}
