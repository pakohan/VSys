package blatt5;

import java.io.IOException;
import java.util.Map;

import forum.framework.IForumView;
import forum.framework.Position;

public final class LocalViewForwarder implements IForumView {
    private IForumView view;

    public LocalViewForwarder(IForumView view) {
        this.view = view;
    }

    @Override
    public void notifyView(Map<String, Position> folks) throws IOException {
        this.view.notifyView(folks);
    }
}
