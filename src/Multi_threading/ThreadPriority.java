package Multi_threading;

import java.util.Random;

public class ThreadPriority {
    // demonstrate changing the priority of a thread

    public static void main(String[] args){
        System.out.println("******** Start Main Thread ********");

        Thread[] threads = new Thread[4];

        Runnable myRunnable = () -> {
            System.out.println("Starting thread.." + Thread.currentThread().getName());
            var num = new Random().nextInt(10);
            try {
                for (int i = 0; i < num; i++) {
                    Thread.sleep(250);
                }
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("Terminating thread.." + Thread.currentThread().getName());
        };

        //initial threads and setPriority at random
        var random = new Random();
        for (int i=0;i< threads.length;i++){
            var rand = random.nextInt(10);
            threads[i] = new Thread(myRunnable,"myThread-"+i);
            threads[i].setPriority(rand);
            System.out.printf("Initialised  %s.setPriority(%d)\n", threads[i].getName(), rand);
        }

        //start all threads
        for (int i=0;i< threads.length;i++){
            System.out.printf("calling  %s.start()\n", threads[i].getName());
            threads[i].start();
        }

        System.out.println("******** End Main Thread ********");

    }


}
