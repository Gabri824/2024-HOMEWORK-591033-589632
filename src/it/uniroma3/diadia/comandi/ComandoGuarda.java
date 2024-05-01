package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * ComandoGuarda - classe che crea un comando e stampa una descrizione attuale della partita
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * 
 * @version 2.0
 */
public class ComandoGuarda implements Comando {

	private IO console;
	private static final String NOME="guarda";
	
	/**
	 * Metodo che stampa le informazioni della partita
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		console.mostraMessaggio("Borsa:");
		console.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		console.mostraMessaggio("I CFU rimanenti al giocatore sono:");
		console.mostraMessaggio(partita.getGiocatore().getCfu()+" CFU.\n");
	}

	@Override
	public void setParametro(String parametro) {
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
	public String getParametro() {
		return null;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}

}
