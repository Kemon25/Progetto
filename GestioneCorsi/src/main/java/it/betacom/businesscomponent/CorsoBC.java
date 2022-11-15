package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;
import it.betacom.businesscomponent.validate.Validazione;

public class CorsoBC {

	private Connection conn;

	public CorsoBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(Corso corso) throws DAOException {
		CorsoDAO.getFactory().create(conn, corso);
	}

	public void delete(long idCorso) throws SQLException {
		CorsoDAO.getFactory().delete(conn, idCorso);
	}

	public Date getUltimoCorso() throws SQLException {
		Date DataMagg = null;
		ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
		for (int i = 0; i < corsi.size(); i++) {
			if (i == 0) {
				DataMagg = corsi.get(i).getDataInizio();
			} else {
				if (corsi.get(i).getDataInizio().compareTo(DataMagg) > 0) {
					DataMagg = corsi.get(i).getDataInizio();
				}
			}
		}
		return DataMagg;
	}

	public int getMediaCorsi() throws DAOException {

		Corso corso;
		int avg = 0;
		ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
		ArrayList<Integer> valori = new ArrayList<Integer>();

		for (int i = 0; i < corsi.size(); i++) {
			long data1 = corsi.get(i).getDataInizio().getTime();
			long data2 = corsi.get(i).getDataFine().getTime();

			long durataCorso = Math.abs(data1 - data2);
			int giorni = (int) TimeUnit.DAYS.convert(durataCorso, TimeUnit.MILLISECONDS);
			valori.add(giorni + 1);
		}

		for (int i = 0; i < valori.size(); i++) {
			avg += valori.get(i);
		}

		avg /= valori.size();
		return avg;

	}

	public int getNumCommenti() throws DAOException {
		ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
		int i = 0;
		for (Corso c : corsi) {
			if (c.getCommenti() != null) {
				i++;
			}
		}
		return i;
	}

	public ArrayList<Docente> getDocentiMultiCorso() throws DAOException {
		ArrayList<Docente> multidocente = new ArrayList<Docente>();
		ArrayList<Docente> docenti = DocenteDAO.getFactory().getAll(conn);
		for (Docente d : docenti) {
			ArrayList<Corso> corsi = CorsoDAO.getFactory().getCorsiByIdDocente(conn, d.getId());
			if (corsi.size() > 1)
				multidocente.add(d);
		}
		return multidocente;
	}

	public ArrayList<Corso> getCorsiDisponibili() throws DAOException, ClassNotFoundException, IOException {
		ArrayList<Corso> corsiDisponibili = new ArrayList<Corso>();
		ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
		for (Corso c : corsi) {
			if (c.getDataInizio().getTime() > new Date().getTime() && Validazione.getFactory().getStatoCorso(c)) {
				corsiDisponibili.add(c);
			}
		}
		return corsiDisponibili;

	}
}
