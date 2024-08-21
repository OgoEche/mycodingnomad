package generic;

// 1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
// 2.) Create a few objects of your generic class with different data types to demonstrate it's dynamic usage.

public class GenContainer<T, U> {
    T value;
    U[] array;

    public GenContainer(T value, U[] array) {
        this.value = value;
        this.array = array;
    }

    public static void main(String[] args) {

        String[] names = "Johnny,Kamil,Shane,Winn".split(",");
        var value = names.length;
        GenContainer<Integer, String>  intStr = new GenContainer<>(value, names);
        for(var v: intStr.getArray()) System.out.println(v);

        Integer[] nums = {1,2,2,3,2,4,7};
        Integer size = nums.length;
        GenContainer<Integer, Integer>  intInt = new GenContainer<>(size, nums);
        for(var v: intInt.getArray()) System.out.println(v);


    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public U[] getArray() {
        return array;
    }

    public void setArray(U[] array) {
        this.array = array;
    }
}
