package blatt1;

/**
 * User: mogli
 * Date: 24.03.13
 * Time: 17:17
 */
public final class Waiter extends Thread {
    private volatile AsyncPrimeClient waiter;
    private ClientEndpoint endpoint;

    public Waiter(ClientEndpoint endpoint, AsyncPrimeClient waiter) {
        this.waiter = waiter;
        this.endpoint = endpoint;
    }

    public void run() {
        boolean isPrime = endpoint.blockingReceive();
        waiter.finish();
        System.out.println((isPrime ? " eine " : " keine ") + "Primzahl");
    }
}
