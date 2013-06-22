package blatt6;

import forum.framework.IForumModel;
import forum.framework.IForumView;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public final class RmiModelForwarder implements IForumModel {
    private IRemoteForumModel server;

    public RmiModelForwarder() {
        try {
            Registry reg = LocateRegistry.getRegistry(1099);
            this.server = (IRemoteForumModel) reg.lookup("blatt7/server");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registerView(String s, IForumView iForumView) throws AlreadyBoundException, IOException {
        server.registerView(s, new RmiViewReceiver(iForumView));
    }

    @Override
    public void deregisterView(String s) throws NotBoundException, IOException {
        server.deregisterView(s);
    }

    @Override
    public void moveNorth(String s) throws NotBoundException, IOException {
        server.moveNorth(s);
    }

    @Override
    public void moveEast(String s) throws NotBoundException, IOException {
        server.moveEast(s);
    }

    @Override
    public void moveSouth(String s) throws NotBoundException, IOException {
        server.moveSouth(s);
    }

    @Override
    public void moveWest(String s) throws NotBoundException, IOException {
        server.moveWest(s);
    }
}
