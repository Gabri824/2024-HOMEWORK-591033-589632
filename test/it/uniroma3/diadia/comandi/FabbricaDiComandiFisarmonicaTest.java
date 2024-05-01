package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaDiComandiFisarmonicaTest {

	FabbricaDiComandiFisarmonica fabbrica;
	Comando comando;
	IO io;
	
	@BeforeEach
	void setUp() throws Exception {
		io=new IOConsole();
		fabbrica=new FabbricaDiComandiFisarmonica(io);
	}

	@Test
	void testCostruisciComandoAiuto() {
		comando=fabbrica.costruisciComando("aiuto");
		assertEquals(new ComandoAiuto().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoVai() {
		comando=fabbrica.costruisciComando("vai");
		assertEquals(new ComandoVai().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoPrendi() {
		comando=fabbrica.costruisciComando("prendi");
		assertEquals(new ComandoPrendi().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoPosa() {
		comando=fabbrica.costruisciComando("posa");
		assertEquals(new ComandoPosa().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoGuarda() {
		comando=fabbrica.costruisciComando("guarda");
		assertEquals(new ComandoGuarda().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoNonValido() {
		comando=fabbrica.costruisciComando("saluta");
		assertEquals(new ComandoNonValido().getNome(), comando.getNome());
	}
	
	@Test
	void testCostruisciComandoFine() {
		comando=fabbrica.costruisciComando("fine");
		assertEquals(new ComandoFine().getNome(), comando.getNome());
	}

}
