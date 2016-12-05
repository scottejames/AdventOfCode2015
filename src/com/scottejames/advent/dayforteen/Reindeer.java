package com.scottejames.advent.dayforteen;

public class Reindeer  {
	public enum State {
		FLYING, RESTING
	};
	private int points;
	private int time;
	private State state;
	private int nextEvent;
	private int speed;
	private int flyTime;
	private int restTime;
	private String name;
	private int distance;
	public String toString(){
		String stateName = state==State.FLYING?"Flying":"Resting";
		return " R: " + name + " has moved " + distance +  " is "+ stateName + " can move at " + speed + " for " +flyTime + " then needs to rest for " + restTime + " and has " + points + " points";
	}
	public Reindeer(String _name, int _flyTime, int _restTime, int _speed) {
		name = _name;
		flyTime = _flyTime;
		restTime = _restTime;
		state = State.FLYING;
		speed = _speed;
		nextEvent = flyTime;
	}

	public void tic() {
		if (state == State.FLYING)  distance += speed;

		time++;
		if (time == nextEvent) {
			if (state == State.FLYING) {
				state = State.RESTING;
				nextEvent = time + restTime;
			} else {
				state = State.FLYING;
				nextEvent = time + flyTime;
			}
		}

	}
	
	public int getSpeed(){
		return speed;
	}
	public int getDistance(){
		return distance;
	}
	public String getName(){
		return name;
	}
	public void incrPoints(){
		points++;
	}
	public int getPoints(){
		return points;
	}
}
