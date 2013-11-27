package fr.pomcompot.runaway.timer;

import javax.inject.Named;

import org.springframework.stereotype.Service;

@Service
@Named
public class TimerImpl implements Timer {
	private long startTime = System.currentTimeMillis();

	@Override
	public void start(long startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public long getElapsedTime() {
		return System.currentTimeMillis() - startTime;
	}
	
	@Override
	public long reset() {
		this.startTime = System.currentTimeMillis();
		return this.startTime;
	}
}
