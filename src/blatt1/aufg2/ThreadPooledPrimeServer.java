package blatt1.aufg2;


import blatt1.ServerEndpoint;

import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooledPrimeServer extends Thread {
    private final ServerEndpoint endpoint;
    private final ExecutorService pool;
    private Boolean isKilled = false;

    private static final int numbercores = Runtime.getRuntime().availableProcessors();
    private static final double nonBlockingFactor = 1.0;

    public ThreadPooledPrimeServer() {
        endpoint = new ServerEndpoint();
        int x = new Double(Math.ceil(nonBlockingFactor * numbercores)).intValue();
        pool = Executors.newFixedThreadPool(x);
    }

    public void run() {
        System.out.println("Threaded PrimeServer up and running...");

        while (!isKilled) {
            pool.execute(new Handler(endpoint.blockingReceive(), endpoint));
        }
    }

    public static void main(String[] args) {
        new ThreadPooledPrimeServer().start();
    }
}
