package verteilte.systeme.ab3.aufgabe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;

public class MesswertClient {

    public static void main(String[] args) throws IOException {
        String serverHostname = "localhost";
        System.out.println("Verbindung zum Host " + serverHostname + " mit port 50000 wird aufgebaut...");
        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket(serverHostname, 50000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            while (true) {
                // Get the current system time and format it
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                // Build a string with the current time and a random number between 0 and 100
                String outString = calendar.getTime().toString() + " " + Math.random()*100;

                // Send that string to the server
                out.println(outString);

                // Print the server response to the console
                System.out.println("echo: " + in.readLine());

                // Wait 5 seconds
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            /*
            out.close();
            in.close();
            stdIn.close();
            echoSocket.close();
            */
        } catch (IOException e) {
            System.out.println("I/O-Fehler bei der Kommunikation mit Host" + serverHostname);
            e.printStackTrace();
        }
    }
}
