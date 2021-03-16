package verteilte.systeme.vorlesung.echoServer;

import java.net.*;

public class EchoClient {
    private static final int BUFSIZE = 508;
    private static final int TIMEOUT = 2000;

    public static void main(String[] args) {
        String host = "localhost";
        int port = 50000;
        byte[] data = "Hello World".getBytes();

        try (DatagramSocket socket = new DatagramSocket()){
            socket.setSoTimeout(TIMEOUT);
            InetAddress addr = InetAddress.getByName(host);
            DatagramPacket packetOut = new DatagramPacket(data, data.length, addr, port);
            socket.send(packetOut);
            DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
            socket.receive(packetIn);
            String recieved = new String(packetIn.getData(), 0 , packetIn.getLength());
            System.out.println("Recieved: " + recieved);
        } catch (SocketTimeoutException e ) {
            System.err.println("Timeout: "  + e.getMessage());
        }catch (Exception e) {
            System.err.println(e);
        }
    }
}
