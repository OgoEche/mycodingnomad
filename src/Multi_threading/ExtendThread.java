package Multi_threading;

public class ExtendThread extends Thread {
    // Create an application that creates a Thread using the Thread class

    public ExtendThread() {
        start();
    }

    public static void main(String[] args) {

        System.out.println("****** Start Main Thread ******");
        new ExtendThread();
        System.out.println("****** End Main Thread ******");

    }

    @Override
    public void run() {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        try {
            for(int i=0;i<5;i++){
                System.out.println("entering sleep.. " + i);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Terminating thread " + Thread.currentThread().getName());
    }
}
