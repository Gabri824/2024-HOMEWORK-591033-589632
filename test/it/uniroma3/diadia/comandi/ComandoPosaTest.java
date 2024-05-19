package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPosaTest {

	Labirinto l;
	IO io;
	ComandoPosa c;
	Attrezzo a;
	Partita p;
	
	@BeforeEach
	void setUp() throws Exception {
		l = new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		io=new IOConsole();
		c=new ComandoPosa();
		a=new Attrezzo("lampada", 5);
		p=new Partita(l);
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
