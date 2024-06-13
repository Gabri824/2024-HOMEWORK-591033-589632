package it.uniroma3.diadia;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class PartitaTest {
	
	Labirinto l;
			
	Partita p;
	Stanza s1;
	Stanza s2;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException{
		l = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		
		p=new Partita(l);
		s1=p.getLabirinto().getStanzaCorrente();
		s2=p.getLabirinto().getStanzaVincente();
	}
	
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
