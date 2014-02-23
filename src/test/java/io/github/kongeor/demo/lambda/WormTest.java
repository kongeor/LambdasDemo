package io.github.kongeor.demo.lambda;


import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class WormTest {

	private final String NAME = "Chuck";
	private Worm worm;

	@Before
	public void setUp() {
		worm = new Worm(NAME, Worm.Team.RED);
	}
	
	@Test
	public void testWormInitialization() {
		assertThat(worm.getName()).isEqualTo(NAME);
		assertThat(worm.getTeam()).isEqualTo(Worm.Team.RED);
		assertThat(worm.isAlive()).isTrue();
	}
	
	@Test
	public void testThatWormsCanDie() {
		worm.setLife(0);
		assertThat(worm.isAlive()).isFalse();
	}

}
