package it.uniroma3.diadia.ambienti;

import java.util.*;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe LabirintoBuilder: si occupa di aggiungere attrezzi e stanze (anche particolari), nel labirinto
 * tenendo conto dell'ultima stanza aggiunta
 * 
 * @author 591033 && 589632
 * 
 * @see Attrezzo
 * @see Stanza
 * @see Labirinto
 * 
 * @version 3.0
 */


public class LabirintoBuilder {
	private Labirinto labirinto;
	private Map<String, Stanza> nome2stanza;
	private Stanza ultimaStanzaAggiunta;
	
	/**
	 * Metodo costruttore di labirinto builder
	 */
	public LabirintoBuilder() {
		this.labirinto=new Labirinto();
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
	
	/**
	 * Metodo che aggiunge una adiacenza a delle stanze del labirinto
	 * @param stanzaCorrente
	 * @param stanzaAdiacente
	 * @param direzione
	 * @return riferimento a LabirintoBuilder
	 */
	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiacente, String direzione) {
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
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzione, String nomeAttrezzo) {
		Stanza stanzaBloccata=new StanzaBloccata(nomeStanza, direzione, nomeAttrezzo);
		this.ultimaStanzaAggiuntaEAggiorna(stanzaBloccata);
		
		return this;
	}

}
