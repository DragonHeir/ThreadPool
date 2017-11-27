package thread_pool;

import java.util.ArrayDeque;

public class ThreadPool {
	private int totalThreads;
	private ArrayDeque<Task> taskQueve;
	private Thread[] threads;
	public ThreadPool(int totalThreads) {
		this.totalThreads = totalThreads;
		taskQueve = new ArrayDeque<Task>();
		threads = new Thread[totalThreads];
		for (int i = 0; i < totalThreads; i++) {
			threads[i] = new Thread(new Worker(taskQueve));
		}
	}
	public void addTask(Task task) {
		taskQueve.add(task);
	}
	public void start() {
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		for (int j = 0; j < threads.length; j++) {
			try {
				threads[j].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
}
