package it.uniroma3.diadia.ambienti;

/**
 * StanzaBloccata - Classe che costruisce una stanza della partita con una direzione bloccata,
 * e per accedere alla Stanza adiacente alla direzione bloccata, vi è bisogno di uno attrezzo apposito
 * 
 * @author 591033 && 589632
 * 
 * @see Stanza
 * 
 * @version 2.0
 */

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String nomeAttrezzo;
	
	/**
	 * Metodo costruttore che implementa una Stanza Bloccata
	 * @param nome
	 * @param direzione
	 * @param nomeAttrezzo
	 */
	public StanzaBloccata(String nome, String direzione, String nomeAttrezzo) {
		super(nome);
		this.direzioneBloccata=direzione;
		this.nomeAttrezzo=nomeAttrezzo;
	}
	
	/**
	 * Metodo sovrascritto della classe Stanza che ritorna il riferimento alla stanza attuale se non 
	 * è presente l'attrezzo per sbloccare l'accesso oppure ritorna il riferimento alla Stanza adiacente
	 * 
	 * @param direzione
	 * 
	 * @return un riferimento alla stanza corrente o adiacente
	 */
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzioneBloccata.equals(direzione)&&!this.hasAttrezzo(nomeAttrezzo))
			return (this);
		
		return super.getStanzaAdiacente(direzione);
	}
	
	/**
	 * Metodo sovrascritto della classe Stanza che se non è presente l'attrezzo ritorna una descrizione diversa della stanza
	 * oppure se è presente ritorna la descrizione della Stanza
	 * 
	 * @return bloccato o la descrizione della classe Stanza
	 */
	@Override
	public String getDescrizione() {
		String bloccato=new String();
		bloccato="La direzione "+direzioneBloccata+" per andare alla stanza adiacente è bloccata, hai bisogno dell 'attrezzo: "+nomeAttrezzo+" per sblocarla";
		if(!this.hasAttrezzo(nomeAttrezzo))
			return bloccato;
		
		return super.getDescrizione();
        
    }

}
