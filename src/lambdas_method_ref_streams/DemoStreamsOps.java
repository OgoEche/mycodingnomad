package lambdas_method_ref_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *  Stream API demo
 */
public class DemoStreamsOps {

    public static void main(String[] args) {
        var message = "";

        //Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
        IntStream.rangeClosed(1,15).forEach(System.out::println);

        //Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
        //to get the sum of the modified list
        var sum = IntStream.range(1,20).peek(System.out::print).map(x -> x*x).sum();
        System.out.println(sum);


        message = """
                Demonstrate the filter function by filtering out all Integers that are less than 10 - then use the average
                function to average the remaining numbers, assign this result to an int variable.
                """;
        System.out.println(message + " :");
        List<Integer> someList = List.of(3,10,6, 14, 30, 1, 5, 4, 11, 15, 4);
        var result = someList.stream().mapToInt(x -> x).filter(x -> x > 10).average();
        System.out.println("average " + result);

        System.out.println("Demonstrate the reduce() function to determine the sum of a list of Integers:");
        var resultReduce = someList.stream().reduce(Integer::sum);
        System.out.println("reduce to demo summation : " + resultReduce);

        System.out.println("Demonstrate how to Stream a text file and print out each line:" );
        var file = Path.of("src/lambdas_method_ref_streams/stream_text_lab.csv");
        try ( var lines = Files.lines(file);){
            lines.forEach(System.out::println);
         } catch (IOException e) {
             System.out.println(e.getMessage());
         }

        message = """
                Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
                then print out the element at the 1 index for each array.
                """;
        System.out.println(message + " :");
        try (var lines = Files.lines(file);) {
            lines.forEach(line -> System.out.println(line.split(",")[1]));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        message = """
                Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
                then print out the sum of all elements at index 2.
                """;
        System.out.println(message + " :");
        try (var lines = Files.lines(file)) {
            var sumDouble = lines.map(line -> line.split(",")[2]).mapToDouble(Double::parseDouble).sum();
            System.out.println(sumDouble);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Demonstrate the anyMatch() function.");
        var  anyMatch = someList.stream().anyMatch(v -> v == 4);
        System.out.println(anyMatch);

        System.out.println("Demonstrate the allMatch() function.");
        var ones = List.of(1,1,1,1,1,1);
        System.out.println("All ones ? " + (ones.stream().anyMatch(v -> v==1) ? "Yes" : "No") );


        System.out.println("Demonstrate the collect() terminal operation to store resulting values into a List");
        var names = List.of("Rachel,Johnny,Obinna,mark,bonna,rachel, JOHnny,MARK".split(","));
        var groupBy = names.stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                        .entrySet();
        System.out.println(groupBy);


    }
}
