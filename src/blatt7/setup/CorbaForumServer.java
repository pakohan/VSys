package blatt7.setup;

import blatt7.server.CorbaModelReceiver;
import forum.framework.ForumServer;

public class CorbaForumServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//run with -ORBInitialPort 1050 args

		CorbaModelReceiver modelReceiver = new CorbaModelReceiver(args);
		
		ForumServer server = new ForumServer(modelReceiver);

		try {
			
			System.out.println("CorbaForumServer running...");
			server.run();
			
		} catch (Exception e) {
			System.err.println("Server crashed!");
		}
	}

}
