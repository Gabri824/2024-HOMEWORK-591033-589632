package it.uniroma3.diadia.ambienti;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	Stanza s1;
	Stanza s2;
	Attrezzo lampada;
	String buio;
	
	@BeforeEach
	void setUp() throws Exception {
		s1=new StanzaBuia("salone", "lampada");
		s2=new Stanza("cucina");
		buio="qui c'è buio pesto";
		lampada=new Attrezzo("lampada", 3);
		
		s1.impostaStanzaAdiacente("est", s2);
	}

	@Test
	void testGetDescrizioneSenzaAttrezzo() {
		assertEquals(s1.getDescrizione(), buio);
	}
	
	@Test
	void testGetDescrizioneConAttrezzo() {
		s1.addAttrezzo(lampada);
		assertNotEquals(s1.getDescrizione(), buio);
	}

}
