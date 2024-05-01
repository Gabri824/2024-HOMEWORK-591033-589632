package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class StanzaBloccataTest {

	Stanza s1;
	Stanza s2;
	Attrezzo chiave;
	Borsa borsa;
	
	@BeforeEach
	void setUp() throws Exception {
		s1=new StanzaBloccata("salone", "nord", "chiave");
		s2=new Stanza("bagno");
		borsa=new Borsa(15);
		chiave=new Attrezzo("chiave", 5);
		s1.impostaStanzaAdiacente("nord", s2);
		
		
		
	}

	@Test
	void testGetStanzaAdiacente() {
		s1.addAttrezzo(chiave);
		assertEquals(s1.getStanzaAdiacente("nord"), s2);
	}
	
	@Test
	void testGetStanzaAdiacenteNo() {
		assertEquals(s1.getStanzaAdiacente("nord"), s1);
	}

	@Test
	void testGetDescrizioneConAttrezzo() {
		s1.addAttrezzo(chiave);
		assertEquals(s1.getDescrizione(), s1.toString());
	}
	
	@Test
	void testGetDescrizioneSenzaAttrezzo() {
		assertNotEquals(s1.getDescrizione(), s1.toString());
	}

}
