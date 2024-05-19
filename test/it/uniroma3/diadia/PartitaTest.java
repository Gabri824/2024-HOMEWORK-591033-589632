package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	Labirinto l= new LabirintoBuilder()
			.addStanzaIniziale("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.addAdiacenza("Atrio", "Biblioteca", "nord")
			.getLabirinto();
	Partita p=new Partita(l);
	Stanza s1=p.getLabirinto().getStanzaCorrente();
	Stanza s2=p.getLabirinto().getStanzaVincente();

	@Test
	void testGetStanzaVincente() {
		assertEquals(s2, p.getLabirinto().getStanzaVincente());
	}

	@Test
	void testGetStanzaCorrente() {
		assertEquals(p.getLabirinto().getStanzaCorrente(), s1);
	}

	@Test
	void testVinta() {
		assertFalse(p.vinta());
	}

	@Test
	void testGetCfu() {
		assertEquals(p.getGiocatore().getCfu(), 20);
	}

}
