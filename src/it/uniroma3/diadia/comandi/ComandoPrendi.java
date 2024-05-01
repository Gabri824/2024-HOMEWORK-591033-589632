package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * ComandoPrendi - classe che crea un comando e che prende un attrezzo dalla stanza e lo aggiunge in borsa
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * @see Attrezzo
 * 
 * @version 2.0
 */
public class ComandoPrendi implements Comando {

	private String nomeAttrezzo;
	private IO console;
	private static final String NOME="prendi";
	
	/**
	 * Metodo che esegue il comando e rimuove un attrezzo dalla stanza e lo aggiunge alla borsa del giocatore
	 * 
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		if (partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			console.mostraMessaggio("Hai preso con successo l'attrezzo.\n");
		}else
			console.mostraMessaggio("L'attrezzo non è presente nella stanza.\n");

	}

	/**
	 * Metodo che imposta il parametro con il nome dell'attrezzo
	 * @param parametro
	 */
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;

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
	 * @return nomeAttrezzo
	 */
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}

}
