package verteilte.systeme.abThreading.aufgabe5;

public class A5 {

    /**
     * Main methode of the programm.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // instantiate a new Konto
        Konto konto = new Konto();

        // instantiate two new threads
        Thread t1 = new Thread(new Einzahler(konto));
        Thread t2 = new Thread(new Einzahler(konto));

        // start the threads
        t1.start();
        t2.start();

        // join the threads to wait for both to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        // write data to system out-stream
        konto.printData();
    }
}
