package verteilte.systeme.abThreading.aufgabe4;

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

    /**
     * Creates a new instance of LogFile and initiates the {@link FileWriter}, {@link BufferedWriter} and
     * {@link PrintWriter} needed to write the file.
     */
    public LogFile() {
        try {
            this.fileWriter = new FileWriter("I:\\Dateien\\DHBW-Stuff\\4. Semester\\Verteilte Systeme\\logfile.txt");
            bufferedWriter = new BufferedWriter(fileWriter);
            out = new PrintWriter(bufferedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes the {@link String} from the {@link StringBuilder} to the file using the {@link PrintWriter} and closes it.
     */
    public void closeWriter() {
        out.write(stringBuilder.toString());
        out.close();
    }

    /**
     * Appends a message to the {@link StringBuilder}.
     *
     * @param msg to be appended.
     */
    public synchronized void writeLine(String msg) {
        // Get the current system time and format it
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        // append the timestamp and message to the String that is later written to the file
        stringBuilder.append(calendar.getTime() + ": " + msg + System.lineSeparator());
    }
}
