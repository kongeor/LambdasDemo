package io.github.kongeor.demo.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WormsManager {
	
	private List<Worm> worms;
	
	public WormsManager() {
		worms = new ArrayList<>();
	}
	
	public static WormsManager createRandom(int capacity) {

		WormsManager manager = new WormsManager();
		
		for(int i=0; i<capacity; i++) {
			manager.getWorms().add(Worm.createRandom());
		}
		
		return manager;
	}
	
	public List<Worm> getWorms() {
		return worms;
	}
	
	public void register(Worm worm) {
		worms.add(worm);
	}
	
	/**
	 * Sorts the worms by their names in ascending order
	 */
	public void sortByName() {

		Comparator<Worm> namesComparator = new Comparator<Worm>() {
			@Override
			public int compare(Worm o1, Worm o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		
		Collections.sort(worms, namesComparator);
	}
	
	/**
	 * Sorts the worms by their names in ascending order, and
	 * if their are the same by their life in descending order
	 */
	public void sortByNameAndLife() {

		Comparator<Worm> comparator = new Comparator<Worm>() {
			@Override
			public int compare(Worm o1, Worm o2) {
				int res = o1.getName().compareTo(o2.getName());
				return res != 0 ? res : o2.getLife() - o1.getLife();
			}
		};
		
		Collections.sort(worms, comparator);
	}
	
	@Override
	public String toString() {
		return worms.toString();
	}

}
