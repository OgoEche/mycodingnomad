package inheritance_ops;

public class TwoWheeler {
    private double weight;

    public TwoWheeler(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "TwoWheeler{" +
                "weight=" + weight +
                '}';
    }
}
