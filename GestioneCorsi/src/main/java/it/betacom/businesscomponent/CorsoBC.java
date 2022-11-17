package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;
import it.betacom.businesscomponent.validate.Validazione;

public class CorsoBC {

	private Connection conn;

	public CorsoBC() {
		try {
			conn = DBAccess.getConnection();
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
	}

	public Corso create(Corso corso) {
		Validazione validazione = Validazione.getFactory();
		DocenteBC dBC = new DocenteBC();
		try {
			if (validazione.nomeCorso(corso.getNomeCorso())
					&& validazione.dateCorso(corso.getDataInizio(), corso.getDataFine())
					&& validazione.commenti(corso.getCommenti()) && validazione.aulaCorso(corso.getAula())
					&& validazione.prezzo(corso.getCosto()))
				if (dBC.getById(corso.getIdDocente()) != null) {
					corso.setIdCorso(CorsoIdGenerator.getIstance().getNextId());
					CorsoDAO.getFactory().create(conn, corso);
					return corso;
				}

		} catch (DAOException | ClassNotFoundException | IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return null;
	}

	public void delete(long idCorso) {
		try {
			CorsoDAO.getFactory().delete(conn, idCorso);
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
	}

	public Date getUltimoCorso() {
		Date DataMagg = null;
		ArrayList<Corso> corsi;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);

			for (int i = 0; i < corsi.size(); i++) {
				if (i == 0) {
					DataMagg = corsi.get(i).getDataInizio();
				} else {
					if (corsi.get(i).getDataInizio().compareTo(DataMagg) > 0) {
						DataMagg = corsi.get(i).getDataInizio();
					}
				}
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return DataMagg;
	}

	public int getMediaCorsi() {
		GregorianCalendar calInizio = new GregorianCalendar();
		GregorianCalendar calFine = new GregorianCalendar();
		ArrayList<Corso> corsi = null;
		int totale = 0;
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
			for (Corso c : corsi) {
				calInizio.setTime(c.getDataInizio());
				calFine.setTime(c.getDataFine());

				int anno = (calFine.get(Calendar.YEAR) - calInizio.get(Calendar.YEAR)) * 365;
				int giorni = calFine.get(Calendar.DAY_OF_YEAR) - calInizio.get(Calendar.DAY_OF_YEAR)+1;
				totale += ((anno + giorni) / 7)*5;
				for (int i = 0; i < (anno + giorni) % 7; i++) {
					int giorno = i + calInizio.get(Calendar.DAY_OF_WEEK);
					switch (giorno) {
					case Calendar.SATURDAY:
					case Calendar.SUNDAY:
						break;
					default:
						totale++;
						break;
					}	
				}
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return totale / corsi.size();
	}

	public int getNumCommenti() {
		int i = 0;
		try {
			ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
			for (Corso c : corsi) {
				if (c.getCommenti() != null) {
					i++;
				}
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return i;
	}

	public ArrayList<Docente> getDocentiMultiCorso() {
		ArrayList<Docente> multidocente = new ArrayList<Docente>();
		DocenteBC docente = new DocenteBC();
		try {
			ArrayList<Docente> docenti = docente.getAll();
			for (Docente d : docenti) {
				ArrayList<Corso> corsi = CorsoDAO.getFactory().getCorsiByIdDocente(conn, d.getId());
				if (corsi.size() > 1)
					multidocente.add(d);
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return multidocente;
	}

	public ArrayList<Corso> getCorsiDisponibili() {
		ArrayList<Corso> corsiDisponibili = new ArrayList<Corso>();
		try {
			ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
			for (Corso c : corsi) {
				if (c.getDataInizio().getTime() > new Date().getTime() && Validazione.getFactory().getStatoCorso(c)) {
					corsiDisponibili.add(c);
				}
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return corsiDisponibili;
	}

	public Corso getById(long id) {
		Corso corso = new Corso();
		try {
			corso = CorsoDAO.getFactory().getById(conn, id);
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return corso;
	}
	
	public  ArrayList<Corso> getAll(){
		
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		try {
			corsi= CorsoDAO.getFactory().getAll(conn);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return corsi;
	}
}
