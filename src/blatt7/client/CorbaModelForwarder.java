package blatt7.client;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;

import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import forum.framework.IForumModel;
import forum.framework.IForumView;
import blatt7.gen.CorbaForumModel;
import blatt7.gen.CorbaForumModelHelper;
import blatt7.gen.CorbaForumView;
import blatt7.gen.CorbaForumViewHelper;

public class CorbaModelForwarder implements IForumModel {
	
	private CorbaForumModel receiver;
	private String[] args;

	public CorbaModelForwarder(String[] args) {
		this.args = args;

		try {
			
			ORB orb = ORB.init(this.args, null);

			NamingContextExt nameService = NamingContextExtHelper.narrow(
					orb.resolve_initial_references("NameService"));

			this.receiver = CorbaForumModelHelper.narrow(
				nameService.resolve_str("ModelReceiver"));

		} catch (Exception e) {
			System.err.println("Model Forwarder crashed!");
			e.printStackTrace();
		}

	}

	@Override
	public void deregisterView(String name) throws NotBoundException,
			IOException {
		
		try {
			
			this.receiver.deregisterView(name);
			
		} catch (blatt7.gen.NotBoundException e) {
			System.err.println("deregisterView crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveEast(String name) throws NotBoundException, IOException {
		
		try {
			
			this.receiver.moveEast(name);
			
		} catch (blatt7.gen.NotBoundException e) {
			System.err.println("moveEast crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveNorth(String name) throws NotBoundException, IOException {
		
		try {
			
			this.receiver.moveNorth(name);
			
		} catch (blatt7.gen.NotBoundException e) {
			System.err.println("moveNorth crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveSouth(String name) throws NotBoundException, IOException {
		
		try {
			
			this.receiver.moveSouth(name);
			
		} catch (blatt7.gen.NotBoundException e) {
			System.err.println("moveSouth crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void moveWest(String name) throws NotBoundException, IOException {
		
		try {
			
			this.receiver.moveWest(name);
			
		} catch (blatt7.gen.NotBoundException e) {
			System.err.println("moveWest crashed!");
			e.printStackTrace();
		}
	}

	@Override
	public void registerView(String name, IForumView view)
			throws AlreadyBoundException, IOException {
	        
			try {
				
				// create and initialize the ORB
				ORB orb = ORB.init(this.args, null);
				
				// get reference to rootpoa & activate the POAManager
				POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
				rootpoa.the_POAManager().activate();
	            
		        // get object reference from the servant
		        org.omg.CORBA.Object ref = rootpoa.servant_to_reference(new CorbaViewReceiver(view));
		        CorbaForumView forumView = CorbaForumViewHelper.narrow(ref);
	            
		        this.receiver.registerView(name, forumView);
		        
			} catch (Exception e) {
				System.err.println("registerView crashed!");
				e.printStackTrace();
			}
		
	}

}
