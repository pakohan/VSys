package blatt6;

import forum.framework.ForumClient;

public final class RmiForumClient {
    public static void main(String[] args) {

        try {
            ForumClient client1 = new ForumClient(new RmiModelForwarder());
            client1.register();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
