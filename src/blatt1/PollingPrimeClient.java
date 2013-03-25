package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * User: mogli
 * Date: 24.03.13
 * Time: 16:45
 */
public class PollingPrimeClient extends Thread {
    private final long number;

    PollingPrimeClient(long number) {
        this.number = number;
    }

    public void run() {
        ClientEndpoint endpoint = new ClientEndpoint();
        SocketAddress server = new InetSocketAddress("localhost", 4711);

        endpoint.send(server, number);

        System.out.print("Die Zahl " + number + " ist");
        Boolean isPrime;
        while (true) {
            isPrime = endpoint.nonBlockingReceive();
            if (isPrime != null) {
                break;
            } else {
                System.out.print(".");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println((isPrime ? " eine " : " keine ") + "Primzahl");
    }

    public static void main(String[] args) {
        for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
            new PollingPrimeClient(i).run();
        }
    }


}
