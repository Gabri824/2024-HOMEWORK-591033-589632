package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * StanzaMagica - classe che crea una stanza magica della partita che raggiunta un determinato numero di
 * attrezzi posati, incomincia man mano che si aggiungono attrezzi a invertirne il nome e raddoppiargli il peso
 * 
 *  @author 591033 && 589632
 *  
 *  @see Stanza
 *  @see Attrezzo
 *  
 *  @version 2.0
 */
public class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	/**
	 * Metodo costruttore della stanza magica, dove viene passato un solo parametro e viene impostata
	 * una soglia magica di default
	 * 
	 * @param nome
	 */
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	/**
	 * Metodo costruttore, dove vengono passati due parametri e viene creata una 
	 * stanza magica con la soglia uguale a un parametro passato
	 * @param nome
	 * @param soglia
	 */
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	
	/**
	 * Metodo sovrascritto della classe stanza, che aggiunge un attrezzo modificato se il numero
	 * degli attrezzi è maggiore della soglia magica
	 * 
	 * @param Attrezzo
	 * 
	 * @return true o false
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
	
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
			attrezzo = this.modificaAttrezzo(attrezzo);
	
		return super.addAttrezzo(attrezzo);
	}
	
	/**
	 * Metodo privato che modifica il nome attrezzo e il peso
	 * 
	 * @param attrezzo
	 * @return attrezzo
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
		pesoX2);
		return attrezzo;
	}

}
