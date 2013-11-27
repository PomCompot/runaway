package fr.pomcompot.runaway.timer;

public interface Timer {

	void start(long startTime);

	long getElapsedTime();

	long reset();

}