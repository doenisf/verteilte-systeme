package verteilte.systeme.abThreading.aufgabe5;

public class Konto {
    private double kontostand = 0;
    private int addCount = 0;

    /**
     * Adds the given value to "kontostand".
     *
     * @param betrag to add.
     */
    public synchronized void add(double betrag) {
        kontostand += betrag;
        addCount++;
    }

    /**
     * Write the data to the system out-stream.
     */
    public void printData() {
        System.out.println("Kontostand: " + kontostand);
        System.out.println("Anzahl Einzahlungnen: " + addCount);
    }
}
