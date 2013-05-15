package blatt5;

import java.io.IOException;
import java.util.Map;

import forum.framework.ForumView;
import forum.framework.IForumView;
import forum.framework.Position;

public final class LocalViewReceiver implements IForumView {
    private IForumView view;

    public LocalViewReceiver(IForumView view) {
        this.view = view;
    }

    public void notifyView(Map<String, Position> folks) throws IOException {
        this.view.notifyView(folks);
    }
}
