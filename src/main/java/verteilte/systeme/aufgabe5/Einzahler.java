package verteilte.systeme.aufgabe5;

public class Einzahler implements Runnable{
    Konto konto;

    public Einzahler(Konto konto) {
        this.konto = konto;
    }

    @Override
    public void run() {
        konto.add(Math.random()*1000);
    }
}
