package io.github.kongeor.demo.lambda;

import java.awt.Point;
import java.util.Random;

public class Worm implements Creature {

    private static final Random random = new Random();
    private static final int INITIAL_LIFE = 100;

    public enum Team {
        RED, BLUE, GREEN
    }

    private final String name;
    private final Team team;
    private int life;

    public Worm(String name, Team team) {
        this.name = name;
        this.team = team;
        life = INITIAL_LIFE;
    }

    public static Worm createRandom() {
        Worm worm = new Worm(Names.getRandomName(),
                Team.values()[random.nextInt(Team.values().length)]);
        worm.setLife(random.nextInt(INITIAL_LIFE + 1));
        return worm;
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
    public void move(WorldMap map, Point... points) {
        // move around
    }

    @Override
    public String toString() {
        return name + " (" + life + ") " + team + "\n";
    }

}
