package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * ComandoNonValido - classe che crea un comando non valido e stampa un messagio di errore
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * 
 * @version 2.0
 */
public class ComandoNonValido implements Comando {

	private IO console;
	private static final String NOME="Non valido";
	
	/**
	 * Metodo che esegue il comando e stampa un messaggio
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio("Comando non valido!");
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
