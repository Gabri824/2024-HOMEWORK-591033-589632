package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * ComandoPosa - classe che crea un comando e posa un attrezzo dalla borsa alla stanza
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * 
 * @version 2.0
 */
public class ComandoPosa implements Comando {

	private String nomeAttrezzo;
	private IO console;
	private static final String NOME="posa";
	
	/**
	 * Metodo che esegue il comando e rimuove un attrezzo dalla borsa, aggiungendolo nella stanza corrente
	 * 
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo));
			console.mostraMessaggio("Hai posato con successo l'attrezzo.\n");
		}else
			console.mostraMessaggio("L'attrezzo non è prensente nella borsa.\n");
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
