public class Cockpit {
    private int seats;

    public Cockpit(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        String PANELS = "Instruments:avionics";
        int FLIGHT_CONTROLS = 8;
        return "Cockpit{" +
                "seats=" + seats +
                ", PANELS='" + PANELS + '\'' +
                ", FLIGHT_CONTROLS=" + FLIGHT_CONTROLS +
                '}';
    }
}
