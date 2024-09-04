package data_structures.queue;

import java.util.Arrays;
import java.util.Objects;

public class CustomQueue<T extends Comparable<T>> {
    private T[] array;
    private int pointer = 0;

    public CustomQueue(int size) {
        array = (T[]) new Object[size];
    }

    //Throw a custom exception when trying to pop  an element from an empty Queue
    public T pop() {
        try {
            if(isEmpty()) throw new CustomQueueEmptyException();
        } catch (CustomQueueEmptyException e) {
            e.getMessage();
            return null;
        }
        return array[0];

    }

    /**
     * Size that captures non null data
     * @return
     */
    public long size() {
        return Arrays.stream(array).filter(Objects::nonNull).count();
    }

    public boolean isEmpty() {
        //if pointer at the beginning the array is empty
        return this.pointer == 0;
    }

    //contain the methods peekFirst() and peekLast()
    public T peekLast() {
        var peekPointer = this.pointer;
        return array[--peekPointer];
    }

    public T peekFirst() {
        return array[0];
    }

    //contain a method to print out the data of all elements in the queue
    public void printData() {
        for(int i=0; i<pointer; i++){
            System.out.print(array[i] + ", ");
        }
    }



}

class CustomQueueEmptyException extends Exception {
    public CustomQueueEmptyException () {
        super("Empty Queue!!");
    }
}
