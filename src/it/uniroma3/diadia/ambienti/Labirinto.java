/**
 * 
 */
package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.Cane;
import it.uniroma3.diadia.personaggi.Mago;
import it.uniroma3.diadia.personaggi.Strega;

/**
 * Labirinto: classe che si occupa di gestire e creare il labirinto della partita
 * 
 * @author 591033 & 589632
 * 
 * @see Stanza
 * @see Attrezzo
 * 
 * @version 3.0
 */
public class Labirinto {
	
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException{
		CaricatoreLabirinto cl=new CaricatoreLabirinto(nomeFile);
		cl.carica();
		this.stanzaCorrente=cl.getStanzaIniziale();
		this.stanzaVincente=cl.getStanzaVincente();
	}
	

    /**
     * Crea tutte le stanze e le porte di collegamento
     */
 //   public void creaStanze() {

//		/* crea gli attrezzi */
//  	Attrezzo lanterna = new Attrezzo("lanterna",3);
//		Attrezzo osso = new Attrezzo("osso",1);
   	
		/* crea stanze del labirinto */
//		Stanza atrio = new Stanza("Atrio");
//		Stanza aulaN11 = new Stanza("Aula N11");
//		Stanza aulaN10 = new Stanza("Aula N10");
	//	Stanza laboratorio = new Stanza("Laboratorio Campus");
//		Stanza biblioteca = new Stanza("Biblioteca");
		
		/* collega le stanze */
//		atrio.impostaStanzaAdiacente("nord", biblioteca);
//		atrio.impostaStanzaAdiacente("est", aulaN11);
//		atrio.impostaStanzaAdiacente("sud", aulaN10);
//		atrio.impostaStanzaAdiacente("ovest", laboratorio);
//		aulaN11.impostaStanzaAdiacente("est", laboratorio);
//		aulaN11.impostaStanzaAdiacente("ovest", atrio);
//		aulaN10.impostaStanzaAdiacente("nord", atrio);
//		aulaN10.impostaStanzaAdiacente("est", aulaN11);
//		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
//		laboratorio.impostaStanzaAdiacente("est", atrio);
//		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
//		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
//		aulaN10.addAttrezzo(lanterna);
//		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
//        stanzaCorrente = atrio;  
//		stanzaVincente = biblioteca;
 //   }
	
	/**
	 * Metodo che ritorna un riferimento all'oggetto LabirintoBuilder
	 * @return riferimento a LabirintoBuilder
	 */
    public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
    	return new LabirintoBuilder(labirinto);
    }
    	
    public void setStanzaVincente(Stanza stanzaVincente) {
    	this.stanzaVincente=stanzaVincente;
    }
    

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public static class LabirintoBuilder{
		private Labirinto labirinto;
		private Map<String, Stanza> nome2stanza;
		private Stanza ultimaStanzaAggiunta;
		
		/**
		 * Metodo costruttore di labirinto builder
		 */
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
			this.labirinto=new Labirinto(labirinto);
			this.nome2stanza=new HashMap<String, Stanza>();		
		}
		
		/**
		 * Metodo che ritorna una mappa
		 * @return una mappa delle stanze aggiunte nel labirinto
		 */
		public Map<String, Stanza> getNome2Stanza(){
			return this.nome2stanza;
		}
		
		/**
		 * Metodo che ritorna un labirinto
		 * @return un riferimento a un labirinto
		 */
		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		
		/**
		 * Metodo che aggiorna l'ultima stanza aggiunta e aggiunge un elemento
		 * alla mappa
		 * @param stanza
		 */
		public void ultimaStanzaAggiuntaEAggiorna(Stanza stanza) {
			this.ultimaStanzaAggiunta=stanza;
			this.nome2stanza.put(ultimaStanzaAggiunta.getNome(), ultimaStanzaAggiunta);
		}
		
		/**
		 * Metodo che aggiunge una stanza iniziale al labirinto
		 * @param stanzaIniziale
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
			Stanza stanza=new Stanza(stanzaIniziale);
			this.labirinto.setStanzaCorrente(stanza);
			this.ultimaStanzaAggiuntaEAggiorna(stanza);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge una stanza vincente al labirinto
		 * @param stanzaVincente
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza stanza=new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(stanza);
			this.ultimaStanzaAggiuntaEAggiorna(stanza);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge un attrezzo al labirinto
		 * @param nomeAttrezzo
		 * @param peso
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
			Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
			
			if(this.ultimaStanzaAggiunta==null)
				return this;
			
			this.ultimaStanzaAggiunta.addAttrezzo(attrezzo);
			
			return this;
		}
		
//		public LabirintoBuilder addPersonaggio(String nome, String presentazione) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//			AbstractPersonaggio p = null;
		//
		//			StringBuilder nomeClasse
		//			= new StringBuilder("it.uniroma3.diadia.personaggi.");
		//			nomeClasse.append( nome.substring(1) ) ;
		//			p = (AbstractPersonaggio)Class.forName(nomeClasse.toString()).newInstance();
		//			p.setNome(nome);
		//			p.setPresentazione(presentazione);
		//			if(this.ultimaStanzaAggiunta==null)
		//				return this;
		//			this.ultimaStanzaAggiunta.setPersonaggio(p);
		//			return this;
		//		}

		public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
			Mago m = new Mago(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(m);
			return this;
		}

		public LabirintoBuilder  addCane(String nome, String presentazione, Attrezzo attrezzo) {
			Cane c = new Cane(nome, presentazione, attrezzo);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(c);
			return this;
		}

		public LabirintoBuilder  addStrega(String nome, String presentazione) {
			Strega s = new Strega(nome, presentazione);
			if(this.ultimaStanzaAggiunta==null)
				return this;
			this.ultimaStanzaAggiunta.setPersonaggio(s);
			return this;
		}
		
		
		/**
		 * Metodo che aggiunge una adiacenza a delle stanze del labirinto
		 * @param stanzaCorrente
		 * @param stanzaAdiacente
		 * @param direzione
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, Direzione direzione) {
			Stanza s1=this.nome2stanza.get(stanzaCorrente);
			Stanza s2=this.nome2stanza.get(stanzaAdiacente);
			
			s1.impostaStanzaAdiacente(direzione, s2);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge una stanza al labirinto
		 * @param nomeStanza
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanza(String nomeStanza) {
			Stanza stanza=new Stanza(nomeStanza);
			this.ultimaStanzaAggiuntaEAggiorna(stanza);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge una stanza magica al labirinto
		 * @param nomeStanza
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaMagica(String nomeStanza) {
			Stanza stanzaMagica=new StanzaMagica(nomeStanza);
			this.ultimaStanzaAggiuntaEAggiorna(stanzaMagica);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge una stanza buia al labirinto
		 * @param nomeStanza
		 * @param nomeAttrezzo
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaBuia(String nomeStanza, String nomeAttrezzo) {
			Stanza stanzaBuia=new StanzaBuia(nomeStanza, nomeAttrezzo);
			this.ultimaStanzaAggiuntaEAggiorna(stanzaBuia);
			
			return this;
		}
		
		/**
		 * Metodo che aggiunge una stanza bloccata al labirinto
		 * @param nomeStanza
		 * @param direzione
		 * @param nomeAttrezzo
		 * @return riferimento a LabirintoBuilder
		 */
		public LabirintoBuilder addStanzaBloccata(String nomeStanza, Direzione direzione, String nomeAttrezzo) {
			Stanza stanzaBloccata=new StanzaBloccata(nomeStanza, direzione, nomeAttrezzo);
			this.ultimaStanzaAggiuntaEAggiorna(stanzaBloccata);
			
			return this;
		}
	}
	
	
}
