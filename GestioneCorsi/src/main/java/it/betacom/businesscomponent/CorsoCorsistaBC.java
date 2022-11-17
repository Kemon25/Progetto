package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;
import it.betacom.businesscomponent.validate.Validazione;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() {
		try {
			conn = DBAccess.getConnection();
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
	}

	public void create(CorsoCorsista corsoCorsista) {
		try {
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
		} catch (DAOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}

	public ArrayList<Corso> getCorsiByIdCorsista(long idCorsista) {
		ArrayList<Corso> c = null;
		try {
			c = CorsoCorsistaDAO.getFactory().getCorsiByIdCorsista(conn, idCorsista);
		} catch (DAOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return c;
	}

	public int getNumCorsistaByIdCorso(long idCorso) {
		int num = -1;
		try {
			num = CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, idCorso);
		} catch (DAOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return num;
	}

	public ArrayList<Corso> getCorsoMaxfreq() {
		int maxFreq = 0;
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		ArrayList<Corso> corsiMaxFreq = new ArrayList<Corso>();
		try {
			corsi = CorsoDAO.getFactory().getAll(conn);
			ArrayList<Integer> frequenze = new ArrayList<Integer>(corsi.size());

			for (Corso corso : corsi) {
				frequenze.add(CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, corso.getIdCorso()));
			}
			maxFreq = Collections.max(frequenze);

			int maxFreqSwap = 0;
			for (Corso corso : corsi) {
				maxFreqSwap = CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, corso.getIdCorso());
				if (maxFreqSwap == maxFreq) {
					corsiMaxFreq.add(CorsoDAO.getFactory().getById(conn, corso.getIdCorso()));
				}
			}

		} catch (DAOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return corsiMaxFreq;
	}

	public ArrayList<Corso> getCorsiIscrivibili() {
		ArrayList<Corso> corsiIscrivibili = new ArrayList<Corso>();
		try {
			ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
			for (Corso c : corsi) {
				if (Validazione.getFactory().getStatoCorso(c) && c.getDataInizio().getTime() >= new Date().getTime())
					corsiIscrivibili.add(c);
			}
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.err.println(exc.getMessage());
		}
		return corsiIscrivibili;
	}
}
