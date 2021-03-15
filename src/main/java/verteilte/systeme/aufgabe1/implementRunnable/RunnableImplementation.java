package verteilte.systeme.aufgabe1.implementRunnable;

public class RunnableImplementation implements Runnable{

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableImplementation());
        t1.setName("hip");
        Thread t2 = new Thread(new RunnableImplementation());
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
        for(int i = 0; i <10; i++) {
            writeName(Thread.currentThread().getName());
        }
    }

    private synchronized void writeName(String name) {
        try {
            wait(100);
        } catch (InterruptedException e) {};
        System.out.println(name);
        notify();
    }
}
