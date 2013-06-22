package blatt7.server;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import forum.framework.ForumModel;
import blatt7.gen.AlreadyBoundException;
import blatt7.gen.CorbaForumModel;
import blatt7.gen.CorbaForumModelHelper;
import blatt7.gen.CorbaForumModelPOA;
import blatt7.gen.CorbaForumView;
import blatt7.gen.NotBoundException;

public class CorbaModelReceiver extends CorbaForumModelPOA implements Runnable {
	
	private ForumModel model;
	private String[] args;
	
	public CorbaModelReceiver(String[] args) {
		this.args = args;
		this.model = ForumModel.INSTANCE;
	}

	@Override
	public void run() {

		try {
			
			ORB orb = ORB.init(this.args, null);

			POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
			rootpoa.the_POAManager().activate(); 
	
			NamingContextExt nameService = NamingContextExtHelper.narrow(
					orb.resolve_initial_references("NameService"));
	
			org.omg.CORBA.Object ref = rootpoa.servant_to_reference(this);
			
			CorbaForumModel server = CorbaForumModelHelper.narrow(ref);

			nameService.rebind(nameService.to_name("ModelReceiver"), server);
			
			orb.run();

		} catch (Exception e) {
			System.err.println("Model Receiver crashed!");
		}
		
	}

	@Override
	public void registerView(String name, CorbaForumView view)
			throws AlreadyBoundException {
		
		try {
			
			model.registerView(name, new CorbaViewForwarder(view));

		} catch (java.rmi.AlreadyBoundException e) {
			System.err.println("registerView crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void deregisterView(String name) throws NotBoundException {
		
		try {
			
			this.model.deregisterView(name);
			
		} catch (java.rmi.NotBoundException e) {
			System.err.println("deregisterView crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveNorth(String name) throws NotBoundException {
		
		try {
			
			this.model.moveNorth(name);
			
		} catch (Exception e) {
			System.err.println("moveNorth crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveEast(String name) throws NotBoundException {
		
		try {
			
			this.model.moveEast(name);
			
		} catch (Exception e) {
			System.err.println("moveEast crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveSouth(String name) throws NotBoundException {
		
		try {
			
			this.model.moveSouth(name);
			
		} catch (Exception e) {
			System.err.println("moveSouth crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveWest(String name) throws NotBoundException {
		
		try {
			
			this.model.moveWest(name);
			
		} catch (Exception e) {
			System.err.println("moveWest crashed!");
			e.printStackTrace();
		}
	}

}
