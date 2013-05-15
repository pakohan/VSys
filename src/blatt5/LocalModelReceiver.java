package blatt5;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import forum.framework.ForumModel;
import forum.framework.IForumModel;
import forum.framework.IForumView;

public final class LocalModelReceiver implements IForumModel, Runnable {

    public static final LocalModelReceiver INSTANCE = new LocalModelReceiver();

    private LocalModelReceiver() {}

    @Override
    public void deregisterView(String name) throws NotBoundException, IOException {
        ForumModel.INSTANCE.deregisterView(name);
    }

    @Override
    public void moveEast(String name) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveEast(name);
    }

    @Override
    public void moveNorth(String name) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveNorth(name);
    }

    @Override
    public void moveSouth(String name) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveSouth(name);
    }

    @Override
    public void moveWest(String name) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveWest(name);
    }

    @Override
    public void registerView(String name, IForumView view) throws AlreadyBoundException, IOException {
        ForumModel.INSTANCE.registerView(name, new LocalViewForwarder(view));
    }

    @Override
    public void run() {

    }

}