package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.fixture.Fixture;


class ComandoVaiTest {
	
	IO io;
	ComandoVai vuoto;
	ComandoVai pieno;
	Stanza s1;
	Stanza s2;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Partita p;
	Labirinto l;

	@BeforeEach
	void setUp() throws Exception {
		pieno=new ComandoVai();
		l = Labirinto.newBuilder("labirinto.txt").getLabirinto();
			//	.addStanzaIniziale("Atrio")
			//	.addAttrezzo("martello", 3)
			//	.addStanzaVincente("Biblioteca")
			//	.addAdiacenza("Atrio", "Biblioteca", "nord")
			//	.getLabirinto();
		p=new Partita(l);
		vuoto=new ComandoVai();
		s1=new Stanza("bagno");
		s2=new Stanza("salone");
		io=new IOConsole(new Scanner(System.in));
		vuoto.setIO(io);
		pieno.setIO(io);
		righeDaLeggere=new ArrayList<>();
		righeDaLeggere2=new ArrayList<>();
		
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
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		pieno.setParametro("sud");
		pieno.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	void testPartitaConComandoVai() throws FileNotFoundException, FormatoFileNonValidoException {
		righeDaLeggere.add("vai nord");
		IOSimulator s=Fixture.creaSimulazionePartitaEGiocaEasy(righeDaLeggere);
		
		assertTrue(s.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, s.nextMessaggio());
		assertTrue(s.hasNextMessaggio());
		assertEquals("Biblioteca", s.nextMessaggio());
		assertTrue(s.hasNextMessaggio());
		assertEquals("Hai vinto!", s.nextMessaggio());
	}
	
	@Test
	public void testPartitaConComandoVaiOvest() throws FileNotFoundException, FormatoFileNonValidoException {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");

		IOSimulator s = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(s.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, s.nextMessaggio());
		assertTrue(s.hasNextMessaggio());
		assertEquals("Studio", s.nextMessaggio());
		assertTrue(s.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO_FINE, s.nextMessaggio());
	}

}
