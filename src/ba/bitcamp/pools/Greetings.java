package ba.bitcamp.pools;

import ba.bitcamp.logger.Logger;

public class Greetings implements Runnable {
	private int id;

	public Greetings(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			String message = String.format("Ja sam tred %d izbrojavo sam do %d", this.id, counter);
			counter++;
			
			
			Logger.log("threadlog", message);
		}

	}

}
