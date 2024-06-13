package it.uniroma3.diadia.personaggi;

import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	final static private String MESSAGGIO_SALUTO="Grazie di avermi salutato! "+
	"Sei stato così gentile, che ti sposterò in un posto pieno di utilità.";
	
	final static private String MESSAGGIO_NON_SALUTO="Sei stato molto scortese, "+
	"meriti una punizione con la mia stregoneria.";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String msg;
		List<Stanza> stanzeAdiacenti=partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		Stanza maxAttrezzi=stanzeAdiacenti.get(0);
		Stanza minAttrezzi=stanzeAdiacenti.get(0);
		
		for(Stanza s : stanzeAdiacenti) {
			if(s!=null) {
				if(s.getNumeroAttrezzi()>maxAttrezzi.getNumeroAttrezzi())
					maxAttrezzi=s;
				if(s.getNumeroAttrezzi()<minAttrezzi.getNumeroAttrezzi())
					minAttrezzi=s;
			}
		}
		
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(maxAttrezzi);
			msg=MESSAGGIO_SALUTO;
		}
		else {
			partita.getLabirinto().setStanzaCorrente(minAttrezzi);
			msg=MESSAGGIO_NON_SALUTO;
		}
		
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String msg="EHEHEEHEHEEEEH!!";
		
		return msg;
	}
	
	

}
