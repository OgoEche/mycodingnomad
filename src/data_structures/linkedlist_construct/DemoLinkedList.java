package data_structures.linkedlist_construct;

// Demonstrate mastery of Java's built-in LinkedList class with examples:

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {

    record Car(String name, int seat) {}

    public static void main(String[] args) {

        //create a LinkedList (from Java's libraries)
        LinkedList<Car> cars = new LinkedList<>();

        //use the add function
        cars.add(new Car("Volvo XC90", 7));
        printContent("add", cars);

        //use the addAll function
        cars.addAll(List.of(new Car("Audio 2000", 4), new Car("Pathfinder", 6),
                new Car("Kia soronto", 6)));
        printContent("addAll", cars);

       //use the addFirst function
        cars.addFirst(new Car("Ford", 4));
        printContent("addFirst", cars);

        //use the addLast function
        cars.addLast(new Car("Tesla XXX", 5));
        printContent("addLast", cars);

        //use the getFirst function
        System.out.println("getFirst: " + cars.getFirst());

        //use the getLast function
        System.out.println("getLast: " + cars.getLast());

        //use the set function
        System.out.println("set: " + cars.set(2, new Car("Citreon FF", 4)));

        //use the push function
        cars.push(new Car("Mazda Toyota", 4));

        //use the remove function
        System.out.println("remove: " + cars.remove());

        //use the pop function
        System.out.println("pop : " + cars.pop());

        //use the contains function
        System.out.println("contains : " + cars.contains(new Car("Mazda Toyota", 4)));

        //use the listIterator function
        System.out.println("listIterator: ");
        var carsIter = cars.listIterator();
         while(carsIter.hasNext()) System.out.println(carsIter.next());

        //use the clear function
        cars.clear();

    }

    public static void printContent(String function, List<Car> data){
        System.out.print(function + " :");
        data.forEach(d -> System.out.print(d + ","));
    }
}


