package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class LabirintoTest {
	
	Labirinto l;
	Stanza s;

	@BeforeEach
	void setUp() throws Exception {
		l = Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		s=new Stanza("Bagno");
	}

	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}

	@Test
	void testSetStanzaCorrente() {
		l.setStanzaCorrente(s);
		assertEquals(s, l.getStanzaCorrente());
	}

	@Test
	void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}

}
