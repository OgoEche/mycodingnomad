package Multi_threading;

import java.util.Random;
import java.util.stream.IntStream;

public class SynchronizeThread {
    // Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
    // working as expected
    Integer[] arrays4Sum;
    Random rand = new Random();

    public SynchronizeThread(Integer[] arrays4Sum) {
        this.arrays4Sum = arrays4Sum;
    }

    public static void main(String[] args) {

        Integer[] numbers = {1,2,3,4,5,6,7,8,9,10};
        Thread[] threads = new Thread[4];

        var sync = new SynchronizeThread(numbers);

        //initial threads
        for (int i=0;i< threads.length;i++){
            threads[i] = new Thread(sync.getRunnable(),"myThread-"+i);
        }

        //start all threads
        IntStream.range(0, threads.length).forEach(i -> {
            System.out.printf("calling  %s.start()\n", threads[i].getName());
            threads[i].start();
        });


    }

    public synchronized void sumArray(){
        var sum = 0;
        for(var a:arrays4Sum) {
            sum += a;
        }
        System.out.println(Thread.currentThread().getName() + ": sum of array -> " + sum);

    }

    public Runnable getRunnable() {

        return () -> {
            System.out.println("Starting thread.." + Thread.currentThread().getName());
            sumArray();
            try {
                for (int i = 0; i < rand.nextInt(10); i++) {
                    Thread.sleep(250);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Terminating thread.." + Thread.currentThread().getName());
        };
    }
}
