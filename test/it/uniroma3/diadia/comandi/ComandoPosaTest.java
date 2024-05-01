package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPosaTest {

	IO io;
	ComandoPosa c;
	Attrezzo a;
	Partita p;
	
	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
		c=new ComandoPosa();
		a=new Attrezzo("lampada", 5);
		p=new Partita();
		p.getGiocatore().getBorsa().addAttrezzo(a);
		c.setIO(io);
		c.setParametro(a.getNome());
	}

	@Test
	void testEsegui() {

		c.esegui(p);
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo(a.getNome()));
	}

}
