package blatt6;

import forum.framework.ForumModel;
import forum.framework.IForumView;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiModelReceiver extends UnicastRemoteObject implements IRemoteForumModel, Runnable {
    private static RmiModelReceiver INSTANCE;

    private RmiModelReceiver() throws RemoteException { }

    public static RmiModelReceiver getInstance() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new RmiModelReceiver();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        return INSTANCE;
    }

    @Override
    public void run() {
        try {
            Registry reg = LocateRegistry.getRegistry(1099);
            reg.bind("server", INSTANCE);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void registerView(String s, IForumView iForumView) throws AlreadyBoundException, IOException {
        ForumModel.INSTANCE.registerView(s, new RmiViewForwarder(iForumView));
    }

    @Override
    public void deregisterView(String s) throws NotBoundException, IOException {
        ForumModel.INSTANCE.deregisterView(s);
    }

    @Override
    public void moveNorth(String s) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveNorth(s);
    }

    @Override
    public void moveEast(String s) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveEast(s);
    }

    @Override
    public void moveSouth(String s) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveSouth(s);
    }

    @Override
    public void moveWest(String s) throws NotBoundException, IOException {
        ForumModel.INSTANCE.moveWest(s);
    }

}
