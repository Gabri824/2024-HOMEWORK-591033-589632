package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LabirintoBuilderTest {

	LabirintoBuilder lb;
	
	@BeforeEach
	void setUp() throws Exception {
		lb=new LabirintoBuilder();
	}

	@Test
	void testGetLabirinto() {
		assertNotNull(lb.getLabirinto());
	}

	@Test
	void testAddStanzaIniziale() {
		lb.addStanzaIniziale("salotto");
		assertEquals(lb.getLabirinto().getStanzaCorrente(), lb.getNome2Stanza().get("salotto"));
	}

	@Test
	void testAddStanzaVincente() {
		lb.addStanzaVincente("cucina");
		assertEquals(lb.getLabirinto().getStanzaVincente(), lb.getNome2Stanza().get("cucina"));
	}

	@Test
	void testAddAttrezzo() {
		lb.addStanzaIniziale("salotto");
		lb.addAttrezzo("televisione", 5);
		
		assertEquals(lb.getLabirinto().getStanzaCorrente().getAttrezzo("televisione"), lb.getNome2Stanza().get("salotto").getAttrezzo("televisione"));
	}

	@Test
	void testAddAdiacenza() {
		lb.addStanzaIniziale("salotto");
		lb.getNome2Stanza().put("bagno", new Stanza("bagno"));
		
		lb.addAdiacenza("salotto", "bagno", "est");
		
		assertEquals(lb.getLabirinto().getStanzaCorrente().getStanzaAdiacente("est"), lb.getNome2Stanza().get("bagno"));
	}

	@Test
	void testAddStanzaMagica() {
		lb.addStanzaMagica("camera");
		lb.addStanzaIniziale("salotto");
		lb.addAdiacenza("salotto", "camera", "nord");
		
		assertEquals(lb.getLabirinto().getStanzaCorrente().getStanzaAdiacente("nord"), lb.getNome2Stanza().get("camera"));
	}

	@Test
	void testAddStanzaBuia() {
		lb.addStanzaBuia("camera", "torcia");
		lb.addStanzaIniziale("salotto");
		lb.addAdiacenza("salotto", "camera", "nord");
		
		assertEquals(lb.getLabirinto().getStanzaCorrente().getStanzaAdiacente("nord"), lb.getNome2Stanza().get("camera"));
	}

	@Test
	void testAddStanzaBloccata() {
		lb.addStanzaBloccata("camera", "nord", "chiave");
		lb.addStanzaIniziale("salotto");
		lb.addAdiacenza("salotto", "camera", "nord");
		
		assertEquals(lb.getLabirinto().getStanzaCorrente().getStanzaAdiacente("nord"), lb.getNome2Stanza().get("camera"));
	}

}
