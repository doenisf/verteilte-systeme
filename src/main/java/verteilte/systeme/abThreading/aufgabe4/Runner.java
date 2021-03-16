package verteilte.systeme.abThreading.aufgabe4;

public class Runner implements Runnable {
    private LogFile logFile;

    /**
     * Creates a new instance of {@link Runner}.
     *
     * @param logFile the thread should write its log messages to.
     */
    public Runner(LogFile logFile) {
        this.logFile = logFile;
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
        for (int i = 0; i < 5; i++) {
            logFile.writeLine(Thread.currentThread().getName() + " is logging " + i);
            try {
                Thread.currentThread().sleep((long) (Math.random()*10000));
            } catch (InterruptedException e) {}
        }
    }
}
