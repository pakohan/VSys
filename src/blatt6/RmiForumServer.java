package blatt6;

import forum.framework.ForumServer;

import java.rmi.registry.LocateRegistry;

public class RmiForumServer {
    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099);

            ForumServer server = new ForumServer(RmiModelReceiver.getInstance());
            server.run();
            System.out.println("Server running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
