package Controllers;

import java.util.Timer;
import java.util.TimerTask;

public class EventScheduler {
    private Timer timer;
	
	public EventScheduler() {
		this.timer = new Timer();
	}
	
	public TimerTask addEvent(long delay, Runnable function) {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				function.run();
			}
		};
		
		this.timer.schedule(task, delay);
		return task;
	}
	
	public void stopEvent(TimerTask task) {
		task.cancel();
	}
}
