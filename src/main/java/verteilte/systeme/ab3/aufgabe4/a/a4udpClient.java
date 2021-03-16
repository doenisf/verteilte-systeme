package verteilte.systeme.ab3.aufgabe4.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;

public class a4udpClient {
    private static final int BUFSIZE = 508;
    private static final int TIMEOUT = 200000;

    public static void main(String[] args) {
        String host = "localhost";
        int port = 50000;

        try (DatagramSocket socket = new DatagramSocket()){
            socket.setSoTimeout(TIMEOUT);
            InetAddress addr = InetAddress.getByName(host);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            String userInput;
            System.out.println("Input: ");
            while ((userInput = stdIn.readLine()) != null) {
                byte[] data = userInput.getBytes();
                DatagramPacket packetOut = new DatagramPacket(data, data.length, addr, port);
                socket.send(packetOut);
                DatagramPacket packetIn = new DatagramPacket(new byte[BUFSIZE], BUFSIZE);
                socket.receive(packetIn);
                String recieved = new String(packetIn.getData(), 0 , packetIn.getLength());
                System.out.println("Recieved: " + recieved);
                System.out.println("Input: ");
            }
        } catch (SocketTimeoutException e ) {
            System.err.println("Timeout: "  + e.getMessage());
        }catch (Exception e) {
            System.err.println(e);
        }
    }
}
