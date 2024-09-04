package data_structures.linkedlist_construct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomLinkedList<T extends Comparable<T>> {
    private Node<T> head;

    // internal node to manage Node creation
    class Node<S>{
        S data;
        Node<S> next;

        Node(S data){
            this.data = data;
            this.next = null;
        }

        Node(S data, Node<S> next) {
            this.data = data;
            this.next = next;
        }

        public String toString() {
            return data.toString();
        }


    }
    
    // construct an empty list
    public CustomLinkedList(){
        this.head = null;
    }

    public static void  main(String[] args) {

        String[] city =  { "Barbarashire", "South Daniel", "North Steven", "East Calvintown", "East Brandon",
                "Mariaburgh", "Gregoryview", "South Sheilastad", "East Amyton", "Lake Morgan" };
        int[] population = { 13282575, 16364978, 13713524, 59463353, 82730436, 81480923, 35220919, 2780440,
                56045835, 1270124 };
        
        //define custom linked list
        var cityCustomLinkedLst = new CustomLinkedList<City>();
        
        //Add element to the front of linkedList. Making element head
        System.out.println("addFirst: ");
        cityCustomLinkedLst.addFirst(new City(city[0],population[0]));
        cityCustomLinkedLst.printContent();

        //Add element to the end of the linkedList
        System.out.println("addLast: ");
        cityCustomLinkedLst.addLast(new City(city[1],population[1]));
        cityCustomLinkedLst.printContent();

        //Add all element of a collection into a linkedList
        List<City> cities = new ArrayList<>();
        for(int i=0;i<city.length;i++){
            cities.add(new City(city[i], population[i]));
        }
        System.out.println("addAll: ");
        cityCustomLinkedLst.addAll(cities);
        cityCustomLinkedLst.printContent();
        
        //Remove element from the front of the LinkedList
        System.out.println("removeFirst: " + cityCustomLinkedLst.removeFirst());
        cityCustomLinkedLst.printContent();

        //Remove element from the end of the LinkedList
        System.out.println("removeLast: " + cityCustomLinkedLst.removeLast());
        cityCustomLinkedLst.printContent();

        //Check whether element is in the linkedList
        var cityData = new City(city[4], population[4]);
        System.out.println("contains: " + cityData + "? " + cityCustomLinkedLst.contains(cityData));

    }

    public boolean contains(T data) {

        if (this.head == null) {
            System.out.println("Empty List");
            return false;
        }

        var newNode = new Node<>(data);
        var compareNode = this.head;
        while (compareNode != null && compareNode.next != null) {
            if (compareNode.data.equals(newNode.data)) {
                return true;
            }
            compareNode = compareNode.next;
        }

        return false;
    }

    /**
     * Remove an element from the end of the linkedList.
     * @return
     */

    public Node<T> removeLast() {
        if (this.head == null) {
            System.out.println("Empty List");
            return null;
        }

        var trailingNode = this.head;
        var nextNode = this.head.next;
        while (nextNode != null && nextNode.next != null) {
            trailingNode = nextNode;
            nextNode = nextNode.next;
        }
        trailingNode.next = null;
        return nextNode;
    }

    public Node<T> removeFirst() {
        if (this.head == null) {
            System.out.println("Empty List");
            return null;
        }
        var currentNode = this.head;
        this.head = this.head.next;
        return currentNode;
    }

    /**
     * Add a collection of elements into a linkedList
     * @param list
     * @return
     */

    public void addAll(List<? extends T> list) {
        list.forEach(this::addLast);
    }

    /**
     * addLast adds element to the end of the list
     * @param data
     */
    public void addLast(T data) {
        var newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        }

        var trailingNode = this.head;
        var nextNode = this.head.next;

        while (trailingNode != null && nextNode != null) {
            trailingNode = nextNode;
            nextNode = nextNode.next;
        }

        trailingNode.next = newNode;

    }

    /**
     * Add node to top of the linked list
     * @param data
     * @return
     */
    public void addFirst(T data) {
        var newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        newNode.next = this.head;
        this.head = newNode;
        return;
    }

    /**
     * Print content of LinkedList
     */
    public void printContent() {
        var currentNode = this.head;
        while( currentNode != null) {
            System.out.print(currentNode + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }


}

record City(String name, int population) implements Comparable<City> {
    @Override
    public int compareTo(City c) {
        return this.name().compareTo(c.name());
    }
}
