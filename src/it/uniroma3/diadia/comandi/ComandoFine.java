package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * ComandoFine - classe che crea un comando e stampa un messaggio di fine gioco
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * 
 * @version 2.0
 */
public class ComandoFine extends AbstractComando {

	private IO console;
	private static final String NOME="fine";
	public final static String MESSAGGIO_FINE = "Grazie di aver giocato!";
	/**
	 * Metodo che esegui il comando 
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		console.mostraMessaggio(MESSAGGIO_FINE); 
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
