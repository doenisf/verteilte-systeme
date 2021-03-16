package verteilte.systeme.ab3.aufgabe5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TcpTimeServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(50000);
            Socket clientSocket = null;
            System.out.println("auf Verbindungsanfragen von Client warten.....");
            clientSocket = serverSocket.accept();
            System.out.println("Verbindung erfolgreich aufgebaut.....");
            System.out.println("Auf Input des Clients warten.....");
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                // Get the current system time and format it
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                out.println("It is currently " + calendar.getTime().toString());
            }
            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.err.println("Fehler bei der Kommunikation!");
            e.printStackTrace();
        }
    }
}
