package blatt5;

import blatt5.LocalModelReceiver;
import blatt5.LocalModelForwarder;
import forum.framework.ForumClient;
import forum.framework.ForumServer;

public final class LocalForumSetup {
    public static void main(String[] args) {
        ForumServer server = new ForumServer(LocalModelReceiver.INSTANCE);

        try {
            ForumClient client1 = new ForumClient(new LocalModelForwarder());
            ForumClient client2 = new ForumClient(new LocalModelForwarder());

            client1.register();
            client2.register();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
