package generic;

import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class GenericOperations {

    public static void main(String[] args){

    }

    //Write a generic method that accepts two generic arguments. This generic method should only accept
    //arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
    //numbers were passed in regardless of their type
    public static <T extends Number,R extends Number> double sum(T t, R r) {
        ToDoubleBiFunction<T, R> toDoBiFn = (x, y) -> x.doubleValue() + y.doubleValue();
        return toDoBiFn.applyAsDouble(t, r);
    }


    // Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes
    public static <T> Integer numOfPalindromes(List<T> arrays) {
        return 1;

    }



}
