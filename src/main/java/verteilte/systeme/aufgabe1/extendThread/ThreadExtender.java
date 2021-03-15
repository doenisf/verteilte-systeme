package verteilte.systeme.aufgabe1.extendThread;

public class ThreadExtender extends Thread {
    /**
     * Local variable to set the wait time of the thread.
     */
    private long timeout;

    /**
     * Creates a new instance of {@link ThreadExtender} and sets the wait time to the given time.
     *
     * @param timeout wait time.
     */
    ThreadExtender(long timeout) {
        this.timeout = timeout;
    }

    /**
     * Main methode of the programm.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        ThreadExtender t1 = new ThreadExtender(500);
        t1.setName("hip");
        ThreadExtender t2 = new ThreadExtender(1000);
        t2.setName("hop");
        t1.start();
        t2.start();
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
        while (true) {
            writeName(getName());
        }
    }

    /**
     * Writes the given {@link String} to the system out-stream.
     *
     * @param name to be printed.
     */
    public synchronized void writeName(String name) {
        try {
            wait(timeout);
        } catch (InterruptedException e) {

        }
        System.out.println(name);
        notify();
    }
}
