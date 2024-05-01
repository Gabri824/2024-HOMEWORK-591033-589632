package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	Borsa b= new Borsa();
	Attrezzo torcia;
	Attrezzo manubrio;
	Attrezzo libro;
	

	@BeforeEach
	void setUp() throws Exception {
		torcia=new Attrezzo("torcia", 2);
		manubrio=new Attrezzo("manubrio", 12);
		libro=new Attrezzo("libro", 4);
	}

	@Test
	void testAddAttrezzoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(torcia));
	}
	
	@Test
	void testAddAttrezzoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(manubrio));
	}

	@Test
	void testGetPeso() {
		b.addAttrezzo(torcia);
		assertEquals(torcia.getPeso(), b.getPeso());
	}

	@Test
	void testGetAttrezzo() {
		b.addAttrezzo(torcia);
		assertEquals(torcia, b.getAttrezzo("torcia"));
	}
	
	@Test
	void testRemoveAttrezzo() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		assertNotNull(b.removeAttrezzo("libro"));
	}

}
