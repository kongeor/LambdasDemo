package io.github.kongeor.demo.lambda;

import static org.fest.assertions.api.Assertions.assertThat;
import io.github.kongeor.demo.lambda.Worm.Team;

import org.junit.Before;
import org.junit.Test;

public class WormsManagerTest {

	private WormsManager manager;
	private Worm w1,w2,w3;
	
	@Before
	public void setUp() {
		manager = new WormsManager();
		w1 = new Worm("Chuck", Team.BLUE);
		manager.register(w1);
		w2 = new Worm("Arnold", Team.BLUE);
		manager.register(w2);
		w3 = new Worm("John", Team.RED);
		manager.register(w3);
	}

	@Test
	public void testCorrectSize() {
		assertThat(manager.getWorms().size()).isEqualTo(3);
	}

}
