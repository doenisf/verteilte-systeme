package verteilte.systeme.aufgabe4;

public class A4 {

    public static void main(String[] args) {
        LogFile logFile = new LogFile();

        logFile.writeLine("Programm gestartet");

        Thread t1 = new Thread(new Runner(logFile));
        t1.setName("t1");
        Thread t2 = new Thread(new Runner(logFile));
        t2.setName("t2");

        t1.start();
        t2.start();

        while (t1.isAlive() && t2.isAlive()) {
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
            }
        }
        logFile.writeLine("Programm beendet");
        logFile.closeWriter();
    }
}
