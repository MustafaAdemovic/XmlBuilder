package ba.bitcamp.pools;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ba.bitcamp.logger.Logger;

public class TestGreetings {

	public static void main(String[] args) {
		
		HashMap<String, String> logs = new HashMap<String, String>();
		
		logs.put("threadlog", "threadlog");
		
		try {
			new Logger(logs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		for(int i = 0; i <= 5; i++){
			es.submit(new Greetings(i));
			//new Thread(new Greetings(i)).start();
		}
		
		es.shutdown();
		while(!es.isTerminated()){};
		Logger.log("threadlog", "Program je gotov");
	}

}
