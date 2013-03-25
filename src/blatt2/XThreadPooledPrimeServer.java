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
        javax.swing.JOptionPane.showMessageDialog(null, "alert", "alert", JOptionPane.ERROR_MESSAGE);
    }
}
