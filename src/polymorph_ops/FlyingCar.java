package polymorph_ops;

import inheritance_ops.Car;

public class FlyingCar extends Vehicle implements IFlyable {

    @Override
    public void accelerate(double speed) {
        this.setSpeed(speed + 10);
        super.accelerate(this.getSpeed());
        System.out.println(this.getClass().getSimpleName()  + ": FlyingCar accelerated by " + this.getSpeed());
    }

    public void accelerate(double speed, int distance, double horsepower) {
        this.setSpeed(speed);
        this.setHorsepower(horsepower);
        this.setDistance(distance );
        System.out.println(this.getClass().getSimpleName()  + ": FlyingCar accelerated by " + this.getSpeed() * this.getHorsepower());
    }

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName()  + ": FlyingCar flying at " + this.getDistance());
    }


}
