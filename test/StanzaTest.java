import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	Stanza s1=new Stanza("s1");
	Stanza s2=new Stanza("s2");
	Attrezzo a=new Attrezzo("a", 10);
	Attrezzo b=new Attrezzo("b", 4);
	Attrezzo c=new Attrezzo("c", 7);

	
	
	@Test
	public void testImpostaStanzaAdiacente() {	
		s1.impostaStanzaAdiacente("nord", s2);	
		assertEquals(s2,s1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("nord"));
	}

	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(a));
	}
	
	@Test
	public void testRemoveAttrezzo() {
		s1.addAttrezzo(a);
		s1.addAttrezzo(b);
		s1.addAttrezzo(c);
		assertTrue(s1.removeAttrezzo(b));
		
	}
	
	@Test
	public void testHasAttrezzo() {
		s1.addAttrezzo(a);
		s1.addAttrezzo(b);
		s1.addAttrezzo(c);
		assertTrue(s1.hasAttrezzo("c"));
		
	}
}
