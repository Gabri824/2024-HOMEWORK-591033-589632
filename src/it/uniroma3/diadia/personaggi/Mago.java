package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {

	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
			
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	
	private Attrezzo attrezzo;
	
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;	
	}
			
	@Override
	public String agisci(Partita partita) {
		String msg;
		
		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;	
		}
		else {
			msg = MESSAGGIO_SCUSE;	
		}
		
		return msg;	
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg="Grazie per il regalo, birichino. Per il tuo regalo, ti meriti un altro regalo.";
		
		Attrezzo a=new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		
		return msg;
		
	}
	
	

}