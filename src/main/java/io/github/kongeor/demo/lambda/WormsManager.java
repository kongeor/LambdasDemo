package io.github.kongeor.demo.lambda;

import java.util.ArrayList;
import java.util.List;

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

}
