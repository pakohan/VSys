package blatt5;

import java.io.IOException;
import java.util.Map;

import forum.framework.IForumView;
import forum.framework.Position;

public final class LocalViewReceiver implements IForumView {
    //    private ForumView view;

    public LocalViewReceiver() {
        //        this.view = new ForumView();
    }

    @Override
    public void notifyView(Map<String, Position> folks) throws IOException {
    }

}
