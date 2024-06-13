package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoSaluta extends AbstractComando {

	private IO io;
	private static final String MESSAGGIO="Non esiste una persona da salutare.";
	
	public static final String NOME="saluta";

	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		
		if(personaggio!=null)
			io.mostraMessaggio(personaggio.saluta());
		else
			io.mostraMessaggio(MESSAGGIO);
		
	}
	
	@Override
	public void setIO(IO io) {
		this.io=io;
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
