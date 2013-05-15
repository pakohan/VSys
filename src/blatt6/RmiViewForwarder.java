package blatt6;

import forum.framework.IForumView;
import forum.framework.Position;

import java.io.IOException;
import java.util.Map;

public final class RmiViewForwarder implements IRemoteForumView {
    private IForumView view;

    public RmiViewForwarder(IForumView view) {
        this.view = view;
    }

    @Override
    public void notifyView(Map<String, Position> folks) throws IOException {
        this.view.notifyView(folks);
    }
}
