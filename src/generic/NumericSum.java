package generic;

import java.util.List;
import java.util.function.BinaryOperator;

// Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
// Numbers in the ArrayList. Demonstrate how to call this method from the main() method.

public class NumericSum <T extends Number> {

    List<T> numerics;

    public NumericSum(List<T> numerics) {
        this.numerics = numerics;
    }

    //Since the type of the generic is not known until actual type parameterization,
    //It's required that the definition of the operation to be performed is lazily delayed
    //using functional interface. Specifying the actual operation in the reduce function like (x,y) -> x+y,
    // or trying to assign or initial some variable with value will not work
    //Here the BinaryOperator is of type T and will be evaluated when T is known along with operation we want to perform.
    // We can perform any operation
    public T Operation(BinaryOperator<T> ops) {
        return numerics.stream().reduce(ops).orElseThrow();
    }

    public static void main(String[] args) {
        var intNums = List.of(3,4,6,7,9);
        var numericInt = new NumericSum<Integer>(intNums);
        System.out.println("Sum: " + numericInt.Operation(Integer::sum));

        var doubleNums = List.of(3.5,4.1,6.6,7.0,9.1);
        var numericDouble = new NumericSum<Double>(doubleNums);
        System.out.println("Sum: " + numericDouble.Operation(Double::sum));

        System.out.println("Max: " + numericDouble.Operation(Double::max));

        System.out.println("multiplication: " + numericDouble.Operation((x,y) -> x*y));

    }
}
