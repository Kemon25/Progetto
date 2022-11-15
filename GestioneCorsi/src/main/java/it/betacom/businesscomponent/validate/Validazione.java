package it.betacom.businesscomponent.validate;

import java.io.IOException;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.model.Corso;

public class Validazione {

	public static Validazione getFactory() {
		return new Validazione();
	}

	private Validazione() {
	}

	public boolean getStatoCorso(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		if (ccBC != null) {
			int capienza = ccBC.getNumCorsistaByIdCorso(corso.getIdCorso());
			if (capienza < 12) {
				return true;
			}
		}
		return false;
	}

	private boolean vStringa(String nome) {
		String expression = "^[a-zA-Z ]+"; 
		if(nome.length() <= 30) {
			if (nome.matches(expression)) {
				System.out.println("Testato");
				return true;
			}
		}
		return false;
	}
	
	public boolean nomeCorsista(String nome) {
		return vStringa(nome);
	}
	
	public boolean cognomeCorsista(String cognome) {
		return vStringa(cognome);
	}
	
	public boolean nomeCorso(String nome) {
		return vStringa(nome);
	}

	
}
