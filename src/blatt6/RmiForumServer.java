package blatt6;

import forum.framework.ForumServer;

import java.rmi.registry.LocateRegistry;

public final class RmiForumServer {
    public static void main(String[] args) {

        try {
            LocateRegistry.createRegistry(1099);

            ForumServer server = new ForumServer(new RmiModelReceiver());
            server.run();
            System.out.println("Server running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
