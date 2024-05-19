package it.uniroma3.diadia.giocatore;
import java.util.*;

import it.uniroma3.diadia.attrezzi.*;


/**
 * Borsa: classe che si occupa di gestire la borsa del giocatore
 * 
 * @author docente di POO & 591033 & 589632
 * 
 * @see Attrezzo
 * 
 * @version 3.0 
 */

public class Borsa  {
	
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> nome_attrezzi;
	//private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;
	
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
	    nome_attrezzi=new TreeMap<>();
	    this.numeroAttrezzi=0;
	    this.pesoAttuale=0;
	    
	    /*
	    this.attrezzi = new Attrezzo[10]; // speriamo bastino...
	    this.numeroAttrezzi = 0;*/
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
	    /*
	    if (this.numeroAttrezzi==10)
	        return false;
	    */
	    nome_attrezzi.put(attrezzo.getNome(), attrezzo);
	    this.numeroAttrezzi++;
	    this.pesoAttuale+=attrezzo.getPeso();
	    //this.attrezzi[this.numeroAttrezzi] = attrezzo;
	    
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
	    
	    if(this.nome_attrezzi.containsKey(nomeAttrezzo))
	    	a=this.nome_attrezzi.get(nomeAttrezzo);

	   /* for (Attrezzo att : this.attrezzi)	   	
	        if (att!=null&&att.getNome().equals(nomeAttrezzo))        	
	            a = att;
	      */
	    
	    return a;
	}
	
	/**
	 * Metodo che somma il peso di tutti gli attrezzi presenti nella borsa,
	 * e ne restituisce il peso totale
	 * @return peso
	 */
	public int getPeso() {
		
		
		
		/*for (Attrezzo a : this.attrezzi) {
			if(a!=null)
				peso += a.getPeso();
		}*/
		return pesoAttuale;
	}
	
	/**
	 * Metodo che verifica se ci sono attrezzi nella borsa
	 * @return true se non ci sono attrezzi, false altrimenti
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi==0;
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
		
		if(this.hasAttrezzo(nomeAttrezzo)) {
			a=this.nome_attrezzi.get(nomeAttrezzo);
			this.nome_attrezzi.remove(nomeAttrezzo);
			this.numeroAttrezzi--;
		//int i=0;
		
		/*for(Attrezzo appoggio : this.attrezzi) {
			if (appoggio!=null&&appoggio.getNome().equals(nomeAttrezzo)){
				a=appoggio;
				this.attrezzi.remove(appoggio);
				
				this.attrezzi[i]=null;
				numeroAttrezzi--;
				return a;
			}*/
			//i++;
		}
		return a;
	}
	
	public Collection<Attrezzo> getAttrezzi() {
        return this.nome_attrezzi.values();
    }
	
	/**
	 * Metodo che restituisce le informazioni riguardo il contenuto della borsa
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		 if (!this.isEmpty()) {
			 
		     s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
		     s.append("\nGli attrezzi: ");
		     s.append(this.getAttrezzi().toString());
		     
		 }
		 else
		 s.append("Borsa vuota");
		 
		 return s.toString();
		}
	
	List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> lista = new ArrayList<>();
		lista.addAll(this.nome_attrezzi.values());
		
		Collections.sort(lista, new ComparatoreAttrezziPerPeso());
		
		return lista;
		
	}
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		return new TreeSet<Attrezzo>(this.nome_attrezzi.values());
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> map = new TreeMap<>();
		Collection<Attrezzo> keys=this.nome_attrezzi.values();
		
		for(Attrezzo a : keys) {
			if(map.containsKey(a.getPeso())) {
				map.get(a.getPeso()).add(a);
			}
			else {
				Set<Attrezzo> attrezzi = new HashSet<>();
				map.put(a.getPeso(), attrezzi);
				attrezzi.add(a);
			}
		}
		
		return map;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> lista =new TreeSet<>(new ComparatoreAttrezziPerPeso());
		lista.addAll(this.nome_attrezzi.values());
		
		return lista;
	}

	

}
