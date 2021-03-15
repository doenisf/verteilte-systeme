package verteilte.systeme.aufgabe1.extendThread;

public class ThreadExtender extends Thread{
    long timeout;

    ThreadExtender(long timeout) {
        this.timeout = timeout;
    }

    public static void main(String[] args) {
        ThreadExtender t1 = new ThreadExtender(500);
        t1.setName("hip");
        ThreadExtender t2 = new ThreadExtender(1000);
        t2.setName("hop");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        while (true) {
            writeName(getName());
        }
    }

    public synchronized void writeName(String name) {
        try {
            wait(timeout);
        } catch (InterruptedException e) {};
        System.out.println(name);
        notify();
    }
}
