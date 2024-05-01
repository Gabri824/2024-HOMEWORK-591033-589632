package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO & 591033 & 589632
 * 
 * @see Labirinto
 * @see Giocatore
 * @version 2.0
 */

public class Partita {

	private Giocatore giocatore;
    private Labirinto labirinto; 
	private boolean finita;

	/**
	 * Metodo che crea un labirinto e un nuovo giocatore
	 */
	public Partita(){
		giocatore= new Giocatore();
		labirinto= new Labirinto();
	    labirinto.creaStanze();
		this.finita = false;
	}
	
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
	}
	
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
	
	public Giocatore getGiocatore() {
		return giocatore;
	}


	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return labirinto.getStanzaCorrente()== labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.getGiocatore().getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	
}
