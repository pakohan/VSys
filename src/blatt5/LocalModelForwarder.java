package blatt5;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import blatt5.LocalModelReceiver;
import forum.framework.IForumModel;
import forum.framework.IForumView;

public final class LocalModelForwarder implements IForumModel {

    @Override
    public void deregisterView(String name) throws NotBoundException, IOException {
        LocalModelReceiver.INSTANCE.deregisterView(name);
    }

    @Override
    public void moveEast(String name) throws NotBoundException, IOException {
        LocalModelReceiver.INSTANCE.moveEast(name);
    }

    @Override
    public void moveNorth(String name) throws NotBoundException, IOException {
        LocalModelReceiver.INSTANCE.moveNorth(name);
    }

    @Override
    public void moveSouth(String name) throws NotBoundException, IOException {
        LocalModelReceiver.INSTANCE.moveSouth(name);
    }

    @Override
    public void moveWest(String name) throws NotBoundException, IOException {
        LocalModelReceiver.INSTANCE.moveWest(name);
    }

    @Override
    public void registerView(String name, IForumView view) throws AlreadyBoundException, IOException {
        LocalModelReceiver.INSTANCE.registerView(name, new LocalViewReceiver(view));
    }
}
