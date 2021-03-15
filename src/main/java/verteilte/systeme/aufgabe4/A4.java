package verteilte.systeme.aufgabe4;

public class A4 {

    /**
     * Main methode of the programm.
     *
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // new instance of LogFile
        LogFile logFile = new LogFile();

        // log entry that the program started
        logFile.writeLine("Programm gestartet");

        // instantiate and name two new threads
        Thread t1 = new Thread(new Runner(logFile));
        t1.setName("t1");
        Thread t2 = new Thread(new Runner(logFile));
        t2.setName("t2");

        // start the two threads
        t1.start();
        t2.start();

        // join the threads to wait for both to finish
        while (t1.isAlive() && t2.isAlive()) {
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
            }
        }

        // log entry that the program finished
        logFile.writeLine("Programm beendet");

        // close the file writer
        logFile.closeWriter();
    }
}
