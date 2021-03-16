package verteilte.systeme.vorlesung.ipAdressenInJava;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Lookup {

    public static void main(String[] args) throws UnknownHostException {

        String host = "www.google.com";

        InetAddress address = InetAddress.getByName(host);

        System.out.printf("Looking up %s -> %s/%s%n", host, address.getHostName(), address.getHostAddress());

    }

}
