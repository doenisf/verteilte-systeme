package verteilte.systeme.abThreading.aufgabe2;

public class A2 {

    /**
     * Main methode of the programm.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " - Prio: " + Thread.currentThread().getPriority());
    }

}
