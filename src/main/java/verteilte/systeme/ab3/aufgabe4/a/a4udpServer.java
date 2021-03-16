package verteilte.systeme.ab3.aufgabe4.a;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class a4udpServer {
    public static final int BUFSIZE = 508;

    public static void main(String[] args) {
        int port = 50000;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            System.out.println("Server gestartet...");

            while(true) {
                DatagramPacket packetOut = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
                socket.receive(packetIn);
                System.out.println("Recived: " + packetIn.getLength() + " bytes");

                byte[] inData = packetIn.getData();
                String inString = new String(inData, 0, inData.length);
                String outString = new StringBuilder(inString).reverse().toString();
                byte[] outData = outString.getBytes(StandardCharsets.UTF_8);

                packetOut.setData(outData);
                packetOut.setLength(outData.length);
                packetOut.setSocketAddress(packetIn.getSocketAddress());
                socket.send(packetOut);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
