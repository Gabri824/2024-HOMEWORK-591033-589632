package it.uniroma3.diadia.ambienti;

/**
 * StanzaBloccata - Classe che costruisce una stanza della partita buia,
 * e per vedere all'interno della Stanza, vi è bisogno di uno attrezzo apposito
 * 
 * @author 591033 && 589632
 * 
 * @see Stanza
 * 
 * @version 2.0
 */

public class StanzaBuia extends Stanza {
	private String nomeAttrezzo;
	
	/**
	 * Metodo costruttore che implementa una Stanza Buia
	 * @param nome
	 * @param nomeAttrezzo
	 */
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
	}
	
	/**
	 * Metodo sovrascritto che ritorna una descrizione della stanza se è presente l'attrezzo richiesto,
	 * oppure ritorna una descrizione "qui c'è buio pesto"
	 * 
	 * @return buio o la descrizione della stanza
	 */
	@Override
	public String getDescrizione() {
		String buio=new String();
		buio="qui c'è buio pesto";
		if(!this.hasAttrezzo(nomeAttrezzo))
			return buio;
		
        return super.getDescrizione();
    }
}
