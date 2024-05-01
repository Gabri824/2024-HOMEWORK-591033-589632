package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

//import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO & 591033 (Gabriele Iorio) & 589632 (Loris Maria Cicchetti)
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *         
 * @see Stanza
 * @see Partita
 * @see Attrezzo
 * @see IOConsole
 * @see FabbricaDiComandi
 * @see FabbricaDiComandiFisarmonica
 * @see Comando
 * @see IO
 *          
 * @version 2.0
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	//static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"}	;

	private IO io;
	private Partita partita;
	
	
	/**
	 * Metodo per creare una nuova partita al gioco "diadia",
	 * che prende come parametro una console e crea una partita
	 * @param console
	 */
	public DiaDia(IO console) {
		this.io=console;
		this.partita = new Partita();
	}

	/**
	 * Metodo principale che stampa un messaggio di benvenuto e 
	 * legge le istruzione dell'utente che gioca
	 */
	public void gioca() {
		String istruzione; 
//		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 * 
	 * @param istruzione
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica(this.io);
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		io.mostraMessaggio("Hai vinto!");
		//if (!this.partita.giocatoreIsVivo())

		//io.mostraMessaggio("Hai esaurito i cfu...");

		return this.partita.isFinita();
		/*Comando comandoDaEseguire = new Comando(istruzione);

		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;*/
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		io.mostraMessaggio("Borsa:");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	}*/

	/**
	 * Comando "Fine".
	 */
	/*private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/
	
	/**
	 *Comando "Prendi".Controlla se nella stanza è presente l'attrezzo da prendere,
	 * aggiungendolo alla borsa e rimuovendolo dalla stanza e stampa un messaggio di riuscita.
	 *
	 *@param nomeAttrezzo
	 */
	/*private void prendi(String nomeAttrezzo) {
		if (this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)) {
			Attrezzo a=this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			io.mostraMessaggio("Hai preso con successo l'attrezzo.\n");
		}else
			io.mostraMessaggio("L'attrezzo non è presente nella stanza.\n");
			
	}*/
	/**
	 * Comando "Posa". Controlla se nella borsa è presente l'attrezzo da posare,
	 * aggiungendolo alla stanza e stampa un messaggio di riuscita.
	 * 
	 * @param nomeAttrezzo
	 */
	/*private void posa(String nomeAttrezzo) {
		if (partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo));
			io.mostraMessaggio("Hai posato con successo l'attrezzo.\n");
		}else
			io.mostraMessaggio("L'attrezzo non è prensente nella borsa.\n");
	}*/

	public static void main(String[] argc) {
		IO io=new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}