package polymorph_ops;

import inheritance_ops.Car;

public class Controller {
    public static void main(String[] args) {
        // Demonstrate the three forms of Polymorphism:
        //    - Overloading
        //    - Overriding
        //    - Interfaces
        Vehicle v1 = new Vehicle();
        v1.accelerate(45);
        v1.accelerate(10,100);

        FlyingCar fc1 = new FlyingCar();
        fc1.accelerate(10);
        fc1.accelerate(20, 100, 54.6);


        IFlyable[] flyables = { new Bird(), new FlyingCar()};
        for (IFlyable flyable : flyables) {
            flyable.fly();
        }




    }
}
