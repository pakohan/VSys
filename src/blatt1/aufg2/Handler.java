package blatt1.aufg2;

import blatt1.ServerEndpoint;

/**
 * User: mogli
 * Date: 25.03.13
 * Time: 14:02
 */
public final  class Handler implements Runnable {
    private ServerEndpoint.Request request;
    ServerEndpoint endpoint;

    public Handler(ServerEndpoint.Request request, ServerEndpoint endpoint) {
        this.request = request;
        this.endpoint = endpoint;
    }

    private static boolean isPrime(long number) {
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        boolean prime = isPrime(request.getNumber());
        endpoint.send(request.getSender(), prime);
    }
}
