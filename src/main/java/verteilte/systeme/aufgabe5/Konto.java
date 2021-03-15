package verteilte.systeme.aufgabe5;

public class Konto {
    private double kontostand = 0;
    private int addCount = 0;

    public synchronized void add(double betrag) {
        kontostand += betrag;
        addCount++;
    }

    public void printData() {
        System.out.println("Kontostand: " + kontostand);
        System.out.println("Anzahl Einzahlungnen: " + addCount);
    }
}
