package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;
import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;
import it.betacom.businesscomponent.validate.Validazione;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() throws ClassNotFoundException, DAOException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(CorsoCorsista corsoCorsista) throws ClassNotFoundException, IOException, DAOException {
		CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
	}

	public ArrayList<Corso> getCorsiByIdCorsista(long idCorsista) throws DAOException {
		return CorsoCorsistaDAO.getFactory().getCorsiByIdCorsista(conn, idCorsista);
	}

	public int getNumCorsistaByIdCorso(long idCorso) throws DAOException {
		return CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, idCorso);
	}

	public ArrayList<Corso> getCorsoMaxfreq() throws DAOException {
		int maxFreq = 0;
		ArrayList<Corso> corsi = new ArrayList<Corso>();
		ArrayList<Corso> corsiMaxFreq = new ArrayList<Corso>();
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

		return corsiMaxFreq;
	}

	public ArrayList<Corso> getCorsiIscrivibili() throws ClassNotFoundException, IOException, DAOException {
		ArrayList<Corso> l = new ArrayList<Corso>();

		ArrayList<Corso> corsi = CorsoDAO.getFactory().getAll(conn);
		for (Corso c : corsi) {
			if (Validazione.getFactory().getStatoCorso(c))
				l.add(c);
		}

		return l;
	}
}
