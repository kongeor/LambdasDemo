package io.github.kongeor.demo.lambda;

import java.awt.Point;

public class Worm implements Creature {

	public enum Team { RED, BLUE, GREEN }
	
	private final String name;
	private final Team team;
	private int life;
	
	public Worm(String name, Team team) {
		this.name = name;
		this.team = team;
		life = 100;
	}

	public String getName() {
		return name;
	}

	public Team getTeam() {
		return team;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	public boolean isAlive() {
		return life > 0;
	}

	@Override
	public void move(Map map, Point... points) {
		// move around
	}

}
