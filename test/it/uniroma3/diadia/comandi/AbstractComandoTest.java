package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

class AbstractComandoTest {

	FakeComando c;
	Partita p;
	
	@BeforeEach
	void setUp() throws Exception {
		c=new FakeComando();
		p=new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}

	@Test
	void testEsegui() {
		c.esegui(p);
		assertTrue(p.isFinita());
	}

	@Test
	void testGetNome() {
		assertNotEquals(c.getNome(), "AbstractComando");
	}

}
