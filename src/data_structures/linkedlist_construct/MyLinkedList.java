package data_structures.linkedlist_construct;

public class MyLinkedList<T> {
    Node<T> head;

    public MyLinkedList(T data) {
        this.head = new Node<>(data);

    }

    public MyLinkedList(Node<T> head) {
        this.head = head;
    }

    public MyLinkedList() {

    }

    public void addHead(T data) {
        var newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addTail(T data) {
        var newNode = new Node<>(data);

        if (this.head == null) {
            this.head = newNode;
            return;
        }

        var currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = newNode;

    }

    public void addBefore(T data, T compare) {
        var newNode = new Node<>(data);
        // Is the list empty?
        if (this.head == null ) {
            this.head =newNode;
            return;
        }
        // Is the head what you want to follow our new node?
        if (this.head.data == compare) {
            newNode.next = this.head;
            this.head = newNode;
            return;
        }

        // Find the node you want to follow the new node
        // This uses a trailing reference traversal
        var compareNode = this.head;
        Node<T> trailingNode = null;
        while (compareNode != null && compareNode.data != compare) {
            trailingNode = compareNode;
            compareNode = compareNode.next;
        }

        // You are either at the end of the list, or
        // you found the compare data
        // In either case, you can insert newNode
        // between trailingNode and compareNode
        trailingNode.next = newNode;
        newNode.next = compareNode;
    }

    public T removeHead() {
        // Is the list empty?
        if (this.head == null)
            return null;

        // Save the head to return its data
        var returnNode = this.head;

        // Make the head the next item in the list
        this.head = this.head.next;

        // Return the saved head
        return (T) returnNode.data;
    }

    public T removeTail() {
        // Is the list empty?
        if (this.head == null)
            return null;

        // Is there only one item in the list?
        if (this.head.next == null) {
            // You just need to return it
            var returnNode = this.head;
            this.head = null;
            return (T) returnNode.data;
        }

        // Otherwise, you walk the list with two nodes
        var returnNode = this.head;
        var trailingNode = returnNode;

        // As long as you're not at the end
        while (returnNode.next != null) {
            // Make sure trailing node follows one link back
            trailingNode = returnNode;
            returnNode = returnNode.next;
        }

        // You set trailing node as the new end of the list.
        trailingNode.next = null;
        return (T) returnNode.data;
    }

    public void remove(T data) {
        // Is the list empty?
        if (this.head == null)
            return;

        var removeNode = this.head;
        var trailingNode = removeNode;

        // As long as you haven't:
        // - Reached the end of the list, and
        // - Found the data item
        // Keep walking the list
        while (removeNode != null && removeNode.data != data) {
            trailingNode = removeNode;
            removeNode = removeNode.next;
        }

        // If remove_node is null, then you didn't find anything
        if (removeNode != null)
            // Are you removing the head?
            if (removeNode == trailingNode)
                this.head = this.head.next;
            else
                // Excise this node from the list
                trailingNode.next = removeNode.next;
    }

    public boolean find(T data) {
        // Set the current node to the head of the list
        var currentNode = this.head;

        // As long as you haven't:
        // - Reached the end of the list, and
        // - Found the data item
        // Keep walking the list
        while (currentNode != null
                && currentNode.data != data)
            currentNode = currentNode.next;

        // If currentNode is null, then you never found it
        return currentNode != null;
    }

    public static void main(String[] args) {
        MyLinkedList<Person> people = new MyLinkedList<>(new Person("Johnny", 52));
    }

}

record Person(String name,int age){}
