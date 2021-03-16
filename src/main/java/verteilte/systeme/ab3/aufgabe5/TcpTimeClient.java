package verteilte.systeme.ab3.aufgabe5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpTimeClient {
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
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.print("Press ENTER to get the current server time.");
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
                System.out.print("Press ENTER to get the current server time.");
            }
            out.close();
            in.close();
            stdIn.close();
            echoSocket.close();
        } catch (IOException e) {
            System.out.println("I/O-Fehler bei der Kommunikation mit Host" + serverHostname);
            e.printStackTrace();
        }
    }
}
