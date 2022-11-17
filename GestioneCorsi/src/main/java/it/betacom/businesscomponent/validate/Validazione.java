package it.betacom.businesscomponent.validate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.model.Corso;

public class Validazione {

	public static Validazione getFactory() {
		return new Validazione();
	}

	private Validazione() {
	}

	public boolean getStatoCorso(Corso corso) {
		CorsoCorsistaBC ccBC = new CorsoCorsistaBC();
		if (corso != null) {
			int capienza = ccBC.getNumCorsistaByIdCorso(corso.getIdCorso());
			if (capienza < 12) {
				return true;
			}
		}
		return false;
	}

	private boolean vStringa(String nome) {
		String expression = "^[a-zA-Z ]+";
		if ((nome != null) && (nome.length() <= 30)) {
			if (nome.matches(expression)) {
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
		String expression = "^[a-zA-Z $&+,:;=\\\\\\\\?@#|/'<>.^*()%!-]+";
		if ((nome != null) && (nome.length() <= 30)) {
			if (nome.matches(expression)) {
				return true;
			}
		}
		return false;
	}

	public boolean dateCorso(Date inizio, Date fine) {
		if (inizio != null && fine != null) {
			GregorianCalendar calInizio = new GregorianCalendar();
			GregorianCalendar calFine = new GregorianCalendar();
			calInizio.setTime(inizio);
			calFine.setTime(fine);

			int anno = calFine.get(Calendar.YEAR) - calInizio.get(Calendar.YEAR);
			int giorni = calFine.get(Calendar.DAY_OF_YEAR) - calInizio.get(Calendar.DAY_OF_YEAR);
			if (anno != 0 || giorni >= 2)
				return true;
		}
		return false;
	}

	public boolean commenti(String commento) {
		if (commento == null)
			return true;
		if (commento.length() <= 200) {
			return true;
		}
		return false;
	}

	public boolean aulaCorso(String aula) {
		String expression = "^[a-zA-Z0-9]+";
		if ((aula != null) && (aula.length() == 4)) {
			if (aula.matches(expression)) {
				return true;
			}
		}
		return false;
	}

	public boolean prezzo(double prezzo) {
		// cast prezzo a int, cast int in string
		int length = String.valueOf(((int) prezzo)).length();
		if (length <= 6) {
			return true;
		}
		return false;
	}

}
