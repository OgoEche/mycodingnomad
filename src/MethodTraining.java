import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodTraining {

    public static void main(String[] args) {
        var method = new MethodTraining();

        method.overload("John","Mary");
        method.overload("John","Mary", 45);

        int number = 888;
        method.passByValue(number);
        System.out.println(number);

        StringBuffer sb = new StringBuffer("First entry ");
        method.passByReference(sb);
        System.out.println(sb);

        System.out.println(MethodTraining.getMaxNumbers(18,4 ,34,10));

        System.out.println(MethodTraining.countConsonants("AEBCIDFGJOUKLMNPQSTVXZHRWY"));

        System.out.println(MethodTraining.isPrime(37));

        var result = MethodTraining.highest_lowest(new int[] {4,6,7,1,9});
        System.out.println(Arrays.toString(result));

        System.out.println(method.divisible_by_divisors(20, 2,3));

        int[] myNumbers = new int[] {1,2,3,4,5,6,7,8,9};
        MethodTraining.reverse_in_place(myNumbers);
        System.out.println(Arrays.toString(myNumbers));

        System.out.println("Factorial: "+ MethodTraining.factorial(5));

    }

    //Demonstrate method overloading in this class
    public void overload(String a, String b) {
        System.out.println(a + ", " + b);
    }

    public void overload(String a, String b, int c) {
        System.out.println(a + ", " + b + ", " + c);
    }

    //Demonstrate the difference between "pass by value" and "pass by reference"
    public void passByValue(int a) {
        a += 10;
        System.out.println(a);
    }

    public void passByReference(StringBuffer sb) {
        sb.append("passByReference");
    }

    //Method that will return the largest of 4 numbers (all of which are passed in as arguments)
    public static int getMaxNumbers(int... numbers){
        return Arrays.stream(numbers).max().orElse(0);
    }

    //method to count all consonants (the opposite of vowels) in a String
    public static long countConsonants(String letters) {
        var vowels = "aeiouAEIOU";
        return letters.chars().mapToObj(c -> (char)c).filter(s -> !vowels.contains(s.toString())).count();
    }

    //method that will determine whether a number is prime or not
    public static boolean isPrime(long number) {
        for (long i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //method that will return a small array containing the highest and lowest numbers in a given numeric array
    public static int[] highest_lowest(int[] numbers){
        Arrays.sort(numbers);
        return new int[]{numbers[numbers.length-1], numbers[0]};
    }
    // Method that takes 3 arguments (int maxNum, int divisor1, int divisor2) and returns an Integer Arraylist.
    // In this method create an Integer ArrayList and populate it with each number between zero and maxNum that is
    // divisible by both divisor1 and divisor2. Then return this ArrayList. After calling this method, print out the
    // length of the returned list
    public List<Integer> divisible_by_divisors(int maxNum, int divisor1, int divisor2){
        List<Integer> divisible_by_divs = new ArrayList<>();
        for (int i = 1; i < maxNum; i++) {
            if(i%divisor1==0 && i%divisor2==0){
                divisible_by_divs.add(i);
            }
        }
        return divisible_by_divs;
    }

    //method that will reverse an array in place use only one extra temp variable. For this exercise you cannot
    //instantiate a second array. You must reverse the array in place using only one extra temp variable. Hint: this
    //variable is used to temporarily store individual values in the array
    public static void reverse_in_place(int[] numbers) {
        System.out.println("Before: " +Arrays.toString(numbers));
        var temp = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = numbers[numbers.length-i-1];
        }
        numbers[numbers.length-1] = temp;
        System.out.println("After: " +Arrays.toString(numbers));
    }

    //Create a recursive method named factorial that will return the factorial of any number passed to it.
    public static int factorial(int n) {
        return n == 1 ? 1 : n * factorial(n-1);
    }


}
