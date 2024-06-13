package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private static final String NOME_ATTREZZO="osso";
	private Attrezzo attrezzo;
	final static private String MESSAGGIO_CANE="BAU!BAU!BAUUUU!";
	
	public Cane(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo=attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg=MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg="WOOF";
		
		if(attrezzo.getNome().equals(NOME_ATTREZZO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo=attrezzo;
			
			return msg;
		}
		else
			return this.agisci(partita);
		
	}

}
