package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class CaricatoreLabirintoTest {
	/*FIXTURE*/
	private final String monolocale = 
			"Stanze:biblioteca\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String bilocale = 
			"Stanze:N12,N11\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:N12\n"+
			"Vincente:N11\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:martello 3 N12\n"+
			"Uscite:\n";
	
	private CaricatoreLabirinto c;
	StringReader mono;
	StringReader bi;
	
	
	@BeforeEach
	void setUp() throws Exception {
		mono=new StringReader(monolocale);
		bi=new StringReader(bilocale);
	}

	@Test
	public void testMonolocale() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(mono);
		c.carica();
		assertEquals("biblioteca", this.c.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.c.getStanzaVincente().getNome());
		}
	
	@Test
	public void testBilocale() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(bi);
		c.carica();
		assertEquals("N12", this.c.getStanzaIniziale().getNome());
		assertEquals("N11", this.c.getStanzaVincente().getNome());
		}
	
	
	@Test
	public void testBilocaleAttrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		c = new CaricatoreLabirinto(bi);
		c.carica();
		Attrezzo expected = new Attrezzo("martello", 3);
		assertEquals(expected, this.c.getStanzaIniziale().getAttrezzo("martello"));
		}

}
