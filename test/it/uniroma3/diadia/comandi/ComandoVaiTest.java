package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;

import it.uniroma3.diadia.ambienti.*;


class ComandoVaiTest {
	
	IO io;
	ComandoVai vuoto;
	ComandoVai pieno;
	Stanza s1;
	Stanza s2;
	Partita p;

	@BeforeEach
	void setUp() throws Exception {
		pieno=new ComandoVai();
		p=new Partita();
		vuoto=new ComandoVai();
		s1=new Stanza("bagno");
		s2=new Stanza("salone");
		io=new IOConsole();
		vuoto.setIO(io);
		pieno.setIO(io);
		
	}

	@Test
	void testEseguiDirezioneInesistente() {
		p.getLabirinto().setStanzaCorrente(s1);
		vuoto.esegui(p);
		assertEquals(s1, p.getLabirinto().getStanzaCorrente());
	}

	@Test
	void testEsegui() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud", s2);
		pieno.setParametro("sud");
		pieno.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
