package data_structures.linkedlist_construct;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DoubleLinkedList<T extends Comparable<T>> {

    Node<T> head;

    public DoubleLinkedList() {
        this.head = null;
    }

    //define some internal node..
    class Node<S> {
        S data;
        Node<S> prev;
        Node<S> next;

        public Node(S data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public Node(S data, Node<S> prev, Node<S> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public String toString() {
            return this.data.toString();
        }
    }

    public static void main(String[] args) {

        //Define DoubleLinkedList object
        var DLinkedLst = new DoubleLinkedList<Job>();

        //Add job node to the front and traverse content
        DLinkedLst.addFirst(Job.listJobs().get(0));
        DLinkedLst.forwardTraversal();

        DLinkedLst.addFirst(Job.listJobs().get(1));
        DLinkedLst.forwardTraversal();

        DLinkedLst.addLast(Job.listJobs().get(2));
        DLinkedLst.forwardTraversal();


    }

    public void addLast(T data) {
        var newNode = new Node<T>(data);
        if (this.head == null) {
            this.head = newNode;
        }

        var currentNode = this.head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    private void forwardTraversal() {
        var currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /**
     * Add element to the top of the DoubleLinkedList
     * @param data
     */
    public void addFirst(T data) {
        var newNode = new Node<T>(data);
        if (this.head == null) {
          this.head = newNode;
          return;
        }
        //
        newNode.next = this.head;
        head.prev = newNode;
        this.head = newNode;
    }




}


/**
 * Job record embedded with logic to build internal job lists from filesystem
 * @param name
 * @param salary
 */
record Job(String name, String salary) implements Comparable<Job> {
    @Override
    public int compareTo(Job o) {
        return this.name().compareTo(o.name());
    }

    public static List<Job> listJobs() {
        var file = Path.of("src//data_structures//linkedlist_construct//jobs_file.csv");
        List<Job> jobs = new ArrayList<>();
        try {
            var lines = Files.lines(file).toArray();
            for (var val: lines ) {
                var js = val.toString().split(",");
                jobs.add(new Job(js[0],js[1]));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return jobs;
    }


}
