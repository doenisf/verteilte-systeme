package verteilte.systeme.aufgabe4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

public class LogFile {
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter out;
    StringBuilder stringBuilder = new StringBuilder();


    public LogFile() {
        try {
            this.fileWriter = new FileWriter("I:\\Dateien\\DHBW-Stuff\\4. Semester\\Verteilte Systeme\\logfile.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            out = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter() {
        out.write(stringBuilder.toString());
        out.close();
        System.out.println("file written and closed.");
    }

    public synchronized void writeLine(String msg) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        stringBuilder.append(calendar.getTime() + ": " + msg + System.lineSeparator());
        System.out.println("Logged");
    }
}
