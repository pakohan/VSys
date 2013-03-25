package blatt1;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * User: mogli
 * Date: 24.03.13
 * Time: 16:59
 */
public class AsyncPrimeClient extends  Thread {
    private final long number;
    private Boolean finished;

    AsyncPrimeClient(long number) {
        this.number = number;
        finished = false;
    }


    public void run() {
        ClientEndpoint endpoint = new ClientEndpoint();
        SocketAddress server = new InetSocketAddress("localhost", 4711);

        endpoint.send(server, number);
        System.out.print("Die Zahl " + number + " ist");

        new Waiter(endpoint,this).start();

        while (!finished) {

                System.out.print(".");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void main(String[] args) {
        for ( long i = 1000000000000000000L; i < 1000000000000000010L; i++ ) {
            new AsyncPrimeClient(i).run();
        }
    }

    public synchronized void finish() {
        finished = true;
    }
}
