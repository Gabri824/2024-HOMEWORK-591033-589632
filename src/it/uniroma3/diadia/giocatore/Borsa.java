package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Borsa: classe che si occupa di gestire la borsa del giocatore
 * 
 * @author docente di POO & 591033 & 589632
 * 
 * @see Attrezzo
 * 
 * @version 2.0 
 */

public class Borsa {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	/**
	 * Metodo che imposta il peso della borsa con il peso default
	 */
	public Borsa() {
	    this(DEFAULT_PESO_MAX_BORSA);
	}
	
	/**
	 * Metodo che imposta il peso massimo della borsa
	 * @param pesoMax
	 */
	public Borsa(int pesoMax) {
	    this.pesoMax = pesoMax;
	    this.attrezzi = new Attrezzo[10]; // speriamo bastino...
	    this.numeroAttrezzi = 0;
	}
	
	/**
	 * Metodo che inserisce un attrezzo della borsa verificando le condizioni e 
	 * aggiorna se inserisce il numero degli attrezzi presenti nella borsa
	 * @param attrezzo
	 * @return false se non ha inserito l'attrezzo, true altrimenti 
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
	    if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
	        return false;
	    
	    if (this.numeroAttrezzi==10)
	        return false;
	    
	    this.attrezzi[this.numeroAttrezzi] = attrezzo;
	    this.numeroAttrezzi++;
	    return true;
	}
	
	public int getPesoMax() {
	    return pesoMax;
	}
	
	/**
	 * Metodo che restituisce un attrezzo se ha lo stesso nome 
	 * @param nomeAttrezzo
	 * @return un attrezzo
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
	    Attrezzo a = null;

	    for (Attrezzo att : this.attrezzi)	   	
	        if (att!=null&&att.getNome().equals(nomeAttrezzo))        	
	            a = att;
	      
	    
	    return a;
	}
	
	/**
	 * Metodo che somma il peso di tutti gli attrezzi presenti nella borsa,
	 * e ne restituisce il peso totale
	 * @return peso
	 */
	public int getPeso() {
		int peso = 0;
		
		for (Attrezzo a : this.attrezzi) {
			if(a!=null)
				peso += a.getPeso();
		}
		return peso;
	}
	
	/**
	 * Metodo che verifica se ci sono attrezzi nella borsa
	 * @return true se non ci sono attrezzi, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
		
	/**
	 * Metodo che verifica se è presente l'attrezzo dal nome uguale alla stringa
	 * @param nomeAttrezzo
	 * @return vero se esiste, falso altrimenti
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	/**
	 * Metodo che rimuove un attrezzo dalla borsa e restituisce l'attrezzo rimosso
	 * @param nomeAttrezzo
	 * @return attrezzo rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a=null;
		int i=0;
		
		for(Attrezzo appoggio : this.attrezzi) {
			if (appoggio!=null&&appoggio.getNome().equals(nomeAttrezzo)){
				a=appoggio;
				this.attrezzi[i]=null;
				numeroAttrezzi--;
				return a;
			}		
			i++;
		}
		return a;
	}
	
	/**
	 * Metodo che restituisce le informazioni riguardo il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		 if (!this.isEmpty()) {
			 
		     s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		     for (Attrezzo a : this.attrezzi)
		    	 if(a!=null)
		    		 s.append(a.toString()+" ");
		 }
		 else
		 s.append("Borsa vuota");
		 
		 return s.toString();
		}


}
