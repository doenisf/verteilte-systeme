package verteilte.systeme.aufgabe3;

public class A3 implements Runnable{
    /**
     * As long as the flag is true, the while loop will keep on running.
     */
    private boolean flag = true;

    /**
     * Main methode of the programm.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // instantiates a new runnable and names it
        A3 a3 = new A3();
        a3.start("Thread-a3");

        // sleep to give the running thread time to do stuff
        try {
            Thread.currentThread().sleep(6500);
        } catch (InterruptedException e) {}

        // call the stop methode on the runnable to stop the thread
        a3.stop();
    }

    /**
     * Starts a new {@link Thread} and gives it a name.
     *
     * @param name of the thread.
     */
    public void start(String name) {
        // instantiate a new thread and give the constructor the calling runnable
        Thread t = new Thread(this);

        // set the name to the given name
        t.setName(name);

        // start the thread
        t.start();
    }

    /**
     * Sets the flag to false to stop the loop and the thread.
     */
    public void stop() {
        flag = false;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while(flag) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}
