package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;


/**
 * ComandoVai - classe che crea un comando e sposta un giocatore da una stanza all'altra
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * @see Stanza
 * 
 * @version 2.0
 */
public class ComandoVai implements Comando {
	private String direzione;
	private static final String NOME="vai";
	private IO console;
	
	/**
	*Metodo che esegue il comando, se la direzione non esiste stampa un messaggio, se esiste verifica se
	*esiste una stanza adiacente allora il giocatore si sposta
	*
	* @param partita
	*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
			return;
		}
		prossimaStanza=stanzaCorrente.getStanzaAdiacente(this.direzione);
		if(prossimaStanza==null) {
			console.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	
	}
	
	/**
	 * Metodo che imposta un parametro come la direzione
	 * 
	 * @param parametro
	 */
	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}

	/**
	 * Metodo che ritorna il nome del comando
	 * @return NOME
	 */
	@Override
	public String getNome() {
		return NOME;
	}

	/**
	 * Metodo che ritorna il parametro
	 * @return direzione
	 */
	@Override
	public String getParametro() {
		return this.direzione;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}

}
