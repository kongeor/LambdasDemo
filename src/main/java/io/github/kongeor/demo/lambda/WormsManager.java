package io.github.kongeor.demo.lambda;

import io.github.kongeor.demo.lambda.Worm.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WormsManager {

    private List<Worm> worms;

    public WormsManager() {
        worms = new ArrayList<>();
    }

    public List<Worm> getWorms() {
        return worms;
    }

    public void register(Worm worm) {
        worms.add(worm);
    }

    public static WormsManager createRandom(int capacity) {

        WormsManager manager = new WormsManager();

        for (int i = 0; i < capacity; i++) {
            manager.getWorms().add(Worm.createRandom());
        }

        return manager;
    }

    /**
     * Sorts the worms by their names in ascending order
     */
    public void sortByName() {

        Comparator<Worm> namesComparator = new Comparator<Worm>() {
            @Override
            public int compare(Worm w1, Worm o2) {
                return w1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(worms, namesComparator);
    }

    /**
     * Sorts the worms by their names in ascending order, and if their are the
     * same by their life in descending order
     */
    public void sortByNameAndLife() {

        Comparator<Worm> comparator = new Comparator<Worm>() {
            @Override
            public int compare(Worm w1, Worm w2) {
                int res = w1.getName().compareTo(w2.getName());
                return res != 0 ? res : w2.getLife() - w1.getLife();
            }
        };

        Collections.sort(worms, comparator);
    }

    /**
     * Returns the total life for a given team
     */
    public int getTotalLifeFor(Team team) {

        int life = 0;

        for (Worm worm : getWorms()) {
            if (worm.getTeam().equals(team)) {
                life += worm.getLife();
            }
        }

        return life;
    }

    /**
     * Returns the first worm that has a life of 0 or null if all the worms are
     * alive.
     */
    public Worm getFirstDeadWorm() {

        Worm dead = null;

        for (Worm worm : getWorms()) {
            if (!worm.isAlive()) {
                dead = worm;
                break;
            }
        }

        return dead;
    }

    /**
     * Returns the first worm found with the most life
     */
    public Worm getMostLivelyWorm() {

        Worm lively = getWorms().get(0);

        for (Worm worm : getWorms()) {
            if (worm.getLife() > lively.getLife()) {
                lively = worm;
            }
        }

        return lively;
    }

    /**
     * Returns a filtered list based on the predicate
     */
    public List<Worm> filter(WormPredicate predicate) {
        List<Worm> filtered = new ArrayList<>();
        for (Worm worm : getWorms()) {
            if (predicate.test(worm)) {
                filtered.add(worm);
            }
        }
        return filtered;
    }

    /**
     * Returns a comma separated string of the worm names
     */
    public String getCommaSeparatedNames() {

        String names = "";
        int size = getWorms().size();

        for (Worm worm : getWorms()) {
            if (getWorms().get(size - 1).equals(worm)) {
                names += worm.getName();
            } else {
                names += worm.getName() + ", ";
            }
        }

        return names;
    }

    /**
     * Returns a unique list of names separated by commas
     */
    public String getUniqueCommaSeparatedNames() {

        Set<String> names = new HashSet<>();
        for (Worm worm : getWorms()) {
            names.add(worm.getName());
        }
        String result = "";
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            result += it.next();
            if (it.hasNext()) {
                result += ", ";
            }
        }
        return result;
    }

    /**
     * Returns a Map of teams that each has it's worms
     */
    public Map<Team, List<Worm>> getByTeams() {
        Map<Team, List<Worm>> teams = new HashMap<>();
        for (Worm worm : getWorms()) {
            List<Worm> team = teams.get(worm.getTeam());
            if (team == null) {
                team = new ArrayList<>();
                teams.put(worm.getTeam(), team);
            }
            team.add(worm);
        }
        return teams;
    }

    @Override
    public String toString() {
        return worms.toString();
    }

}
