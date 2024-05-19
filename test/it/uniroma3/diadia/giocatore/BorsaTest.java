package it.uniroma3.diadia.giocatore;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	Borsa b;
	Attrezzo torcia;
	Attrezzo manubrio;
	Attrezzo libro;
	

	@BeforeEach
	void setUp() throws Exception {
		b=new Borsa();
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
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		b.addAttrezzo(libro);
		b.addAttrezzo(torcia);
		Collection<Attrezzo> lista=b.getContenutoOrdinatoPerPeso();
		
		assertArrayEquals(b.getContenutoOrdinatoPerPeso().toArray(), lista.toArray());
		
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		b.addAttrezzo(torcia);
		b.addAttrezzo(libro);
		Collection<Attrezzo> lista=b.getContenutoOrdinatoPerNome();
		
		assertArrayEquals(lista.toArray(), b.getContenutoOrdinatoPerNome().toArray());
	}
	
	@Test
	void testGetSortedSetOrdinaPerPeso() {
		b.addAttrezzo(libro);
		b.addAttrezzo(torcia);
		
		Collection<Attrezzo> lista=b.getSortedSetOrdinatoPerPeso();
		
		assertArrayEquals(b.getSortedSetOrdinatoPerPeso().toArray(), lista.toArray());
	}

	
	@Test
	void testGetContenutoRaggruppatoPerPeso() {
		b.addAttrezzo(libro);
		b.addAttrezzo(torcia);
		
		Map<Integer, Set<Attrezzo>> map=b.getContenutoRaggruppatoPerPeso();
		
		assertArrayEquals(b.getContenutoRaggruppatoPerPeso().values().toArray(), map.values().toArray());
	}
}
