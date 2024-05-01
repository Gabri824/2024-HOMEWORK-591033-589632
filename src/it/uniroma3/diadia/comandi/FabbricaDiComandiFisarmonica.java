package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

/**
 * FabbricaDiComandiFisarmonica - classe che crea una fabbrica di comandi e si occupa di creare
 * i comandi del gioco
 * 
 * @author 591033 && 589632
 * 
 * @see Comando
 * @see IO
 * @see ComandoAiuto
 * @see ComandoFine
 * @see ComandoGuarda
 * @see ComandoNonValido
 * @see ComandoPrendi
 * @see ComandoPosa
 * @see ComandoVai
 * 
 * @version 2.0
 */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {

	private IO io;
	
	/**
	 * Metodo costruttore della classe
	 * @param console
	 */
	public FabbricaDiComandiFisarmonica(IO console) {
		this.io=console;
	}
	
	/**
	 * Metodo che costruisce un comando verificando che il comando sia tra quelli disponibile, se no
	 * crea un comando non valido
	 * 
	 * @param istruzione
	 * 
	 * @return comando
	 */
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
		nomeComando = scannerDiParole.next();// prima parola: nome del comando
		if (scannerDiParole.hasNext())
		parametro = scannerDiParole.next(); // seconda parola: eventuale param.
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai();
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi();
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa();
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda();
		else 
			comando = new ComandoNonValido();
		
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;
	}

}
