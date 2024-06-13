package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
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
public class ComandoVai extends AbstractComando {
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
		if (this.getParametro() == null) {
			console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null )
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				console.mostraMessaggio("Direzione inesistente");
				return;
			}
			
			if (prossimaStanza == null) {
			console.mostraMessaggio("Direzione inesistente");
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	
	}
	

	/**
	 * Metodo che ritorna il nome del comando
	 * @return NOME
	 */
	@Override
	public String getNome() {
		return NOME;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}

}
