package thread_pool;

import java.util.ArrayDeque;

public class Worker implements Runnable {
	private ArrayDeque<Task> taskQueve;
	public Worker(ArrayDeque<Task> taskQueve) {
		this.taskQueve = taskQueve;
		taskQueve = new ArrayDeque<Task>();
	}
	public void run() {
		while (taskQueve.size() >= 1) {
			Task t = taskQueve.remove();
			t.perform();
		}
	}


}
