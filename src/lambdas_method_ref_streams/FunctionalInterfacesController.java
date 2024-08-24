package lambdas_method_ref_streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FunctionalInterfacesController {

    public static void main(String[] args) {

        //Implement and use functional Interface NoParamReturnVoid
        NoParamReturnVoid noParam = () -> System.out.println("Might as well print nothing!!");
        noParam.takeNothing();

        //demonstrate creating an anonymous inner class from NoParamReturnVoid interface
        NoParamReturnVoid noParamFromInner = new NoParamReturnVoid() {
            @Override
            public void takeNothing() {
                System.out.println("Might as well print nothing inside this anonymous inner class !!");
            }
        };
        noParamFromInner.takeNothing();



        //Implement and use functional Interface OneParamReturnValue
        OneParamReturnValue<String> oneParam_ReturnValue = value -> value.toLowerCase();
        System.out.println(oneParam_ReturnValue.takeOneReturnOne("Hello world"));

        //Demonstrate creating an anonymous inner class from OneParamReturnValue interface
        OneParamReturnValue<Integer> OneParamReturnValueInner = new OneParamReturnValue<Integer>() {
            @Override
            public Integer takeOneReturnOne(Integer args) {
                return args*args;
            }
        };
        System.out.println(OneParamReturnValueInner.takeOneReturnOne( 5 ));


        //Implement and use functional Interface TwoParamReturnValue
        TwoParamReturnValue<String, String, String> twoParamReturnValue = (first, last) -> first + " " + last;
        System.out.println(twoParamReturnValue.takeTwoReturnOne("Johnny", "Speed"));
        //demonstrate creating an anonymous inner class from TwoParamReturnValue interface
        TwoParamReturnValue<String, String, Integer> twoParamReturnValueInner = new TwoParamReturnValue<String, String, Integer>() {
            @Override
            public Integer takeTwoReturnOne(String s, String s2) {
                return String.valueOf(s.contains(s2)).length();
            }
        };
        System.out.println(twoParamReturnValueInner.takeTwoReturnOne("Johnny", "Speed"));


        //Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());

        Consumer<List<Integer>> someList = values -> values.forEach(System.out::println);
        someList.accept(List.of(2,3,3,4,5,5,7,8));


    }


}

// Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
interface NoParamReturnVoid {
    void takeNothing();
}

// Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
// value of the same type as the parameter
interface OneParamReturnValue<T> {
    T takeOneReturnOne(T args);
}


//Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a value
interface TwoParamReturnValue<T,U, R> {
    R takeTwoReturnOne(T t, U u);
}

