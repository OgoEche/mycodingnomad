package data_structures.stack;

import java.util.Arrays;
import java.util.Objects;

/**
 * Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *  rather than the LinkedList as in the example we have already seen.
 */
public class CustomStack<T> {

    private int pointer = 0;
    private T[] dataArray;

    public CustomStack() {
        this.dataArray = (T[]) new Object[20];
    }

    public T push(T item) {
        dataArray[pointer++] = item;
        if ( size() > dataArray.length * .75 || size() > dataArray.length * .25) resize();
        return item;
    }

    //throw a custom exception when trying to pop an element from an empty Stack
    public T pop() {

        try {
            if (this.empty()) {
                throw new CustomEmptyStackException();
            }
            var item = dataArray[--pointer];
            dataArray[pointer] = null;
            return item;

        } catch (CustomEmptyStackException e) {
            e.getMessage();
            return null;
        }

    }

    // contain the methods peekFirst() and peekLast()
    public T peekLast() {
        var peekPointer = this.pointer;
        return dataArray[--peekPointer];
    }

    public T peekFirst() {
        return dataArray[0];
    }

    /**
     * resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
     * resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
     */
    public void resize() {
        System.out.println("time to resize... ? ");
        //make a copy of the existing table and call it "old"
        T[] old = dataArray;

        //twice the size when the Stack is more than 3/4 full
        if ( size() > dataArray.length * .75){
            dataArray = (T[]) new Object[old.length * 2];
            for(int i=0;i<old.length;i++){
                if (old[i] != null) dataArray[i] = old[i];
            }
            System.out.println("twice the size when the Stack is more than 3/4 full.. ");
            return;
        }

        //half the size when the Stack is more than 1/4 empty
        if ( size() > dataArray.length * .25){
            dataArray = (T[]) new Object[(int) (old.length * .5)];
            for(int i=0;i<dataArray.length;i++){
                if (old[i] != null) dataArray[i] = old[i];
            }
            System.out.println("half the size when the Stack is more than 1/4 empty.. ");
        }

    }

    /**
     * Size that captures non null data
     * @return
     */
    public long size() {
        return Arrays.stream(dataArray).filter(Objects::nonNull).count();
    }

    public boolean empty() {
        //if pointer at the beginning the array is empty
        return this.pointer == 0;
    }

    //contain a method to print out the data of all elements in the Stack
    public void printData() {
        for(int i=0; i<pointer; i++){
            System.out.print(dataArray[i] + ", ");
        }
    }


    public static void main(String[] args) {
        String[] countries = {"Thailand", "Lebanon", "Philippines", "Lebanon", "Iran", "Rwanda", "Marshall Islands",
                "Tunisia", "Portugal", "Brunei Darussalam"};

        CustomStack<String> cStack = new CustomStack<>();

        //load items to custom stack.
        for (var country: countries) {
            System.out.println("push: " + cStack.push(country));
        }

        //Looks at the object at the bottom of this stack without removing it from the stack.
        System.out.println("peekFirst: " + cStack.peekFirst());

        //Looks at the object at the top of this stack without removing it from the stack.
        System.out.println("peekLast: " + cStack.peekLast());

        //Attempt to pop more elements that's in the stack
        for(int i=0;i <= countries.length; i++) {
            System.out.println("pop: " + cStack.pop());
        }

        //Tests if this stack is empty
        System.out.println("empty :" + cStack.empty());

    }


}


class CustomEmptyStackException extends Exception {
    public CustomEmptyStackException() {
        super("Empty Stack!!");
    }
}
