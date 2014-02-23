package io.github.kongeor.demo.lambda;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import io.github.kongeor.demo.lambda.Worm.Team;

import org.junit.Before;
import org.junit.Test;

public class WormsManagerTest {

	private WormsManager manager;
	private Worm w1,w2,w3,w4,w5;
	
	@Before
	public void setUp() {
		manager = new WormsManager();
		w1 = new Worm("Chuck", Team.BLUE);
		manager.register(w1);
		w2 = new Worm("Arnold", Team.BLUE);
		w2.setLife(50);
		manager.register(w2);
		w3 = new Worm("Arnold", Team.RED);
		w3.setLife(70);
		manager.register(w3);
		w4 = new Worm("Arnold", Team.GREEN);
		w4.setLife(30);
		manager.register(w4);
		w5 = new Worm("John", Team.RED);
		manager.register(w5);
	}

	@Test
	public void testCorrectSize() {
		assertThat(manager.getWorms().size()).isEqualTo(5);
	}
	
	@Test
	public void testSortByName() {
		manager.sortByName();
		List<Worm> worms = manager.getWorms();
		
		assertThat(worms.get(0).getName()).isEqualTo("Arnold");
		assertThat(worms.get(1).getName()).isEqualTo("Arnold");
		assertThat(worms.get(2).getName()).isEqualTo("Arnold");
		assertThat(worms.get(3)).isEqualTo(w1);
		assertThat(worms.get(4)).isEqualTo(w5);
	}
	
	@Test
	public void testSortByNameAndLife() {
		manager.sortByNameAndLife();
		assertThat(manager.getWorms()).isEqualTo(Arrays.asList(w3, w2, w4, w1, w5));
	}

}
