package data_structures.linkedlist_construct;

public class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public Node(T data, Node<T> node) {
        this.data = data;
        this.next = node;
    }

    public String toString() {
        return this.data.toString();
    }


}
