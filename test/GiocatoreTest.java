import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	
	Giocatore g= new Giocatore();

	@Test
	void testGetCfu() {
		assertEquals(20, g.getCfu());
	}

	@Test
	void testSetCfu() {
		g.setCfu(5);
		assertEquals(5, g.getCfu());
	}

	@Test
	void testGetBorsa() {
		assertNotNull(g.getBorsa());
	}

}
