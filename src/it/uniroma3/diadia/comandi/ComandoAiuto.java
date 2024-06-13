package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;

/**
 * ComandoAiuto - classe che crea un comando e stampa un elenco di comandi
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see Partita
 * 
 * @version 2.0
 */
public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "interagisci", "saluta", "regala"}	;
    static final private String NOME="aiuto";
	
	/**
	 * Metodo che esegue il comando, stampando l'elenco dei comandi
	 * 
	 * @param partita
	 */
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
		this.getIo().mostraMessaggio("");

	}

	/**
	 * Metodo che ritorna il nome del comando
	 * @return NOME
	 */
	@Override
	public String getNome() {
		return NOME;
	}
}
