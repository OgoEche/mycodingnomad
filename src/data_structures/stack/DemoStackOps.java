package data_structures.stack;

import java.util.Stack;

// Demonstrate your mastery of Java's built-in Stack class
public class DemoStackOps {

    public static void main(String[] args) {
        Stack<String> myStack = new Stack<>();

        String[] friuts = "mango,orange,grape,banana,apple,pear".split(",");
        //load items to stack.
        for (var fruit: friuts) {
            System.out.println("push: " + myStack.push(fruit));
        }

        // Looks at the object at the top of this stack without removing it from the stack.
        System.out.println("peek: " + myStack.peek());


        // Search stack for an object and return 1-based position where an object is on the stack
        System.out.println("search: " + friuts[3] + " -> " + myStack.search(friuts[3]));

        // Pop an object from the top of the stack
        System.out.println("pop: " + myStack.pop());

        //Tests if this stack is empty
        System.out.println("empty :" + myStack.empty());

    }
}
