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


class ComandoPrendiTest {

	Labirinto l;
	IO io;
	ComandoPrendi comando;
	Partita p;
	Attrezzo attrezzo;
	
	@BeforeEach
	void setUp() throws Exception {
		l=new LabirintoBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();
		io=new IOConsole();
		attrezzo=new Attrezzo("libro", 2);
		p=new Partita(l);
		comando=new ComandoPrendi();
		p.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("libro");
		comando.setIO(io);
	}

	@Test
	void testEsegui() {
		comando.esegui(p);
		assertTrue(p.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
	}

}
