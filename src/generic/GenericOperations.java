package generic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToDoubleBiFunction;

public class GenericOperations {

    public static void main(String[] args){

        System.out.println("Generic sum: " + sum(4.6, 7));

        var data = List.of("many","hannah","noon","accident","wow");
        System.out.println("Number of Palindromes: " + numOfPalindromes(data));

        Integer[] nums = {1,2,3,4,5,6,7,8};
        System.out.println("Exchange Position: " + exchangePositions(nums,2, 4));

        System.out.println("largest within range: " + largestWithRange(data,2,4));
        System.out.println("largest within range: " + largestWithRange(Arrays.stream(nums).toList(),2,4));

    }

    //Write a generic method that accepts two generic arguments. This generic method should only accept
    //arguments which are sublasses of Number. The generic method must return the sum (as a double) of whatever two
    //numbers were passed in regardless of their type
    public static <T extends Number,R extends Number> double sum(T t, R r) {
        ToDoubleBiFunction<T, R> toDoBiFn = (x, y) -> x.doubleValue() + y.doubleValue();
        return toDoBiFn.applyAsDouble(t, r);
    }


    // Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes
    public static <T extends String> Integer numOfPalindromes(List<T> arrays) {
        var count = 0;
        for (T word : arrays) {
            if (word.contentEquals(new StringBuilder(word).reverse())) {
                count++;
            }
        }
        return count;
    }

    // Write a generic method to exchange the positions of two different elements in an array.
    public static <T, U extends Integer> String exchangePositions(T[] array, U p1, U p2) {
        T temp = array[p1.intValue()];
        array[p1.intValue()] = array[p2.intValue()];
        array[p2.intValue()] = temp;
        return Arrays.toString(array);
    }


    // Write a generic method to find the largest element within the range (begin, end) of a list.
    public static <T extends Comparable<T>,U extends Integer> T largestWithRange(List<T> list, U begin, U end) {
        return list.subList(begin,end)
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }





}
