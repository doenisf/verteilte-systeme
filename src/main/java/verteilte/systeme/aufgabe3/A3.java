package verteilte.systeme.aufgabe3;

public class A3 implements Runnable{
    private boolean flag = true;

    public static void main(String[] args) {
        A3 a3 = new A3();
        a3.start("Thread-a3");
        try {
            Thread.currentThread().sleep(6500);
        } catch (InterruptedException e) {}
        a3.stop();
    }
    /*
    "Für jeden neu erzeugten Thread ist auch ein neuer Name zur Unterscheidung zu wählen"
    Wenn ich das richtig verstehe soll es hier eine Möglichkeit geben mehrere Threads zu starten und
    denen dann eigene Namen zu geben. Den Namen hätte ich über die Console gesetzt via
    String input = System.console().readLine(); oder ähnlich. Wie genau er den neuen Thread starten will weiß ich noch nicht.
     */
    public void start(String name) {
        Thread t = new Thread(this);
        t.setName(name);
        t.start();
    }

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