package verteilte.systeme.vorlesung.echoServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServer {
    public static final int BUFSIZE = 508;

    public static void main(String[] args) {
        int port = 50000;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            DatagramPacket packetOut = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);

            System.out.println("Server gestartet...");

            while(true) {
                socket.receive(packetIn);
                System.out.println("Recived: " + packetIn.getLength() + " bytes");
                packetOut.setData(packetIn.getData());
                packetOut.setLength(packetIn.getLength());
                packetOut.setSocketAddress(packetIn.getSocketAddress());
                socket.send(packetOut);
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
