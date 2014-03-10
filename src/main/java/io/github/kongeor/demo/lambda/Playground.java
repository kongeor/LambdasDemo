package io.github.kongeor.demo.lambda;

import java.util.List;

import io.github.kongeor.demo.lambda.Worm.Team;

public class Playground {
	
	public static List<Worm> getRedTeamDyingWorms() {
		WormsManager manager = WormsManager.createRandom(100);
		return manager.filter(new WormPredicate() {
			
			@Override
			public boolean test(Worm worm) {
				return worm.getLife() < 10 && worm.getTeam().equals(Team.RED);
			}
		});
	}

	public static void main(String[] args) {
		// let's have fun
	}
}
