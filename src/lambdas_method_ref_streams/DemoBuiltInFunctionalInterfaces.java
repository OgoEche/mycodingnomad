package lambdas_method_ref_streams;

import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Stream;

/**
 *  Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *  10 of them! You can do it! You'll know so much about them when you're done!
 */
public class DemoBuiltInFunctionalInterfaces {

    static record Data(String name, Integer count){}

    public static void main(String[]  args) {

        Predicate<String> emptyOrNot = String::isEmpty;
        System.out.println(emptyOrNot.test("In the making..."));

        UnaryOperator<Integer>  increment = value -> value++;
        System.out.println(increment.apply(10));

        BinaryOperator<Integer>  add = Integer::sum;
        System.out.println(add.apply(4, 10));

        Function<String,Integer> getLength = String::length;
        System.out.println(getLength.apply("We are going to win!!"));

        ToDoubleBiFunction<Float, Integer>  div = (a, b) -> a / b;
        System.out.println(div.applyAsDouble(5.78F, 2));

        Supplier<Data>  someData = () -> new Data("balls", 4);
        System.out.println(someData.get());

        var store = Stream.of("orange", "apple", "grape", "pears").map(o -> new Data(o, o.length())).toList();
        Consumer<List<Data>> listOfData = value -> value.forEach(System.out::println);
        listOfData.accept(store);

        IntPredicate  intPredicate = x -> x > 0 && x < 10;
        System.out.println(intPredicate.test(1));

        BooleanSupplier booleanSupplier = () -> new Random().nextBoolean();
        System.out.println(booleanSupplier.getAsBoolean());

        ObjIntConsumer<Data> objIntConsumer = (obj, val) -> System.out.println(obj + ":" + val);
        objIntConsumer.accept(new Data("stuff", 3), 7);

    }
}
