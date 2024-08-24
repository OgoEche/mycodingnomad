package lambdas_method_ref_streams;

import java.util.function.*;

/**
 * Demonstrate the use of a static method reference
 * an instance method reference
 *  a constructor reference
 */

public class DemoMethodReference {

    public static void main(String[]  args) {

        // constructor reference
        Supplier<String>  someEmptyString = String::new;
        System.out.println(someEmptyString.get());

        // static method reference
        BiFunction<Double, Double, Double>  someStuff = Math::max;
        System.out.println(someStuff.apply(4.5,10.3));

        // instance method reference
        var name = "johnny speed";
        Predicate<String>  someVal = name::contains;
        System.out.println(someVal.test("p"));







    }
}
