package blatt4;

public class GlobalSystem {
	// private final static int PROCESSES = 10;
	private final static int PROCESSES = 10;

	void run() throws InterruptedException {
		Process[] processes = new Process[PROCESSES];

		for (int i = 0; i < processes.length; i++)
			processes[i] = new BullyProcess(i);

		for (Process source : processes) {
			for (Process destination : processes)
				if (!source.equals(destination))
					source.connect(destination);
			new Thread(source).start();
		}

		processes[6].setActive(false);
		processes[8].setActive(false);
		processes[9].setActive(false);
		processes[0].startElection();
        Thread.sleep(10L);
	}

	public static void main(String[] args) throws InterruptedException {
		new GlobalSystem().run();
	}

}
