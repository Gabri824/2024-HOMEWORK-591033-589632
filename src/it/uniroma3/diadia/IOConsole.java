package it.uniroma3.diadia;

import java.util.Scanner;

/**
 * IOConsole: classe che gestisce le stampe e le letture di istruzioni
 * 
 * @see IO
 * 
 * @author docente di POO & 591033 (Gabriele Iorio) & 589632 (Loris Maria Cicchetti)
 * 
 * @version 2.0
 */

public class IOConsole implements IO {
	
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee=scanner;
	}
	
	/**
	 * Metodo che stampa messaggi
	 * @param msg
	 */
	@Override
    public void mostraMessaggio(String msg) {
    	System.out.println(msg);
    }
   
    /**
     * Metodo per leggere istruzioni
     * @return restituisce una stringa
     */
	@Override
    public String leggiRiga() {
    	String riga = scannerDiLinee.nextLine();

    	return riga;

    }
}
