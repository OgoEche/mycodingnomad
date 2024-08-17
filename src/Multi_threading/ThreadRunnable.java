package Multi_threading;

public class ThreadRunnable {
    // 1: Create an application that starts a Thread by implementing the Runnable interface
    // 2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created

    public static void main(String[] args) {
        System.out.println("***** Starting Main Thread ******");

        var myThread = new Thread(() -> System.out.println("My runnable via lambda fuction"), "MyRunnable");
        myThread.start();

        var myRunnable = new MyRunnable();

        System.out.println("***** Ending Main Thread ******");
    }
}

class MyRunnable implements Runnable {
    Thread thread;

    public MyRunnable() {
        thread = new Thread(this, "MyRunnable via Concrete Class");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("starting thread " + thread.getName());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("terminating thread " + thread.getName());

    }
}
