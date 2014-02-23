package io.github.kongeor.demo.lambda;

import java.util.Random;

public class Names {
	
	private static final Random random = new Random();
	
	private static final String[] names = {
		"Arnold", "Chuck", "Steven", "Jean-Claude", "John"
	};

	public static String getRandomName() {
		return names[random.nextInt(names.length)];
	}
}
