package verteilte.systeme.aufgabe5;

public class A5 {

    public static void main(String[] args) {
        Konto konto = new Konto();

        Thread t1 = new Thread(new Einzahler(konto));
        Thread t2 = new Thread(new Einzahler(konto));
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        konto.printData();
    }
}
