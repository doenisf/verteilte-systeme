package verteilte.systeme.ab3.aufgabe2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class DaytimeServer {
    public static final int BUFSIZE = 508;

    public static void main(String[] args) {
        int port = 50000;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            DatagramPacket packetOut = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            while (true) {
                socket.receive(packetIn);
                System.out.println("Request recieved!");


                // Get the current system time and format it
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());

                byte[] data = calendar.getTime().toString().getBytes(StandardCharsets.UTF_8);
                packetOut.setData(data);
                packetOut.setLength(data.length);
                packetOut.setSocketAddress(packetIn.getSocketAddress());
                socket.send(packetOut);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
