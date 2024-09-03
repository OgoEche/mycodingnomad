package data_structures.queue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// Demonstrate your mastery of Java's (sun's) built-in Queue class
public class DemoQueueOps {

    public static void main(String[] args) {

        Queue<String> myQueue = new PriorityQueue<>();

        String[] companies = {"Powers Ltd","Fritz and Sons","Marks, Hughes and Herman","Stevenson, Taylor and Finley",
            "Bailey LLC","Thomas-Miller","Drake-Delgado","Berry, Krause and Martin"};

        //load elements into queue..
        System.out.println("Add: " + Arrays.toString(companies));
        for (var company: companies) {
            myQueue.add(company);
        }
        //Retrieves, but does not remove, the head of this queue
        System.out.println("peek: " + myQueue.peek());

        //the number of elements in this collection
        System.out.println("size: " + myQueue.size());

        //true if this collection contains the specified element
        System.out.println("contains: " + companies[4] + "? " + myQueue.contains(companies[4]));

        // Retrieves and removes the head of this queue, or returns null if this queue is empty.
        System.out.println("poll " + myQueue.poll());

        //Removes a single instance of the specified element from this collection
        System.out.println("remove: " + companies[2] + "? " + myQueue.remove(companies[2]));








    }
}
