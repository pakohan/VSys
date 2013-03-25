package blatt2;

import blatt1.aufg2.ThreadPooledPrimeServer;

import javax.swing.*;

/**
 * User: mogli
 * Date: 25.03.13
 * Time: 14:05
 */
public class XThreadPooledPrimeServer extends ThreadPooledPrimeServer {
    public XThreadPooledPrimeServer() {
        super();
        new Pane(this).start();
    }

    public void kill() {
        super.isKilled = true;
    }

    public static void main(String[] args) {
        new XThreadPooledPrimeServer().start();
    }

    private static final class Pane extends  Thread {
        XThreadPooledPrimeServer server;

        private Pane(XThreadPooledPrimeServer server) {
            this.server = server;
        }

        public void run() {
            javax.swing.JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
            server.kill();
        }
    }
}
