package verteilte.systeme.aufgabe1.extendThread;

public class ThreadExtender extends Thread{

    public static void main(String[] args) {
        ThreadExtender t1 = new ThreadExtender();
        t1.setName("hip");
        ThreadExtender t2 = new ThreadExtender();
        t2.setName("hop");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            writeName(getName());
        }
    }

    public synchronized void writeName(String name) {
        try {
            wait(100);
        } catch (InterruptedException e) {};
        System.out.println(name);
        notify();
    }

    /*
    "in einer Endlosschleife unterschiedlich schnell ausgibt"
    Da kannst du auch schauen ob es einen anderen Weg gibt dies zu realisieren.
     */
}
