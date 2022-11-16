package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaBCTest {
	private static Connection conn;
	private static CorsoCorsistaBC ccBC;
	private static CorsoCorsista cc;
	private static CorsoBC cBC;
	private static CorsistaBC corsistaBC;
	private static Corso corso;
	private static Corsista corsista;

	@BeforeAll
	static void setUpBeforeClass() throws DAOException, ClassNotFoundException, IOException {

		conn = DBAccess.getConnection();
		cc = new CorsoCorsista();
		cc.setIdCorsista(4);
		cc.setIdCorso(4);

		corso = new Corso();
		corso.setIdCorso(4);
		corso.setIdDocente(1);
		corso.setNomeCorso("Analisi");
		corso.setDataInizio(new GregorianCalendar(2022, 11, 16).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 16).getTime());
		corso.setCosto(1000.00);
		corso.setCommenti("bho si fa analisi");
		corso.setAula("c1A4");

		corsista = new Corsista();
		corsista.setId(4);
		corsista.setNome("Max");
		corsista.setCognome("Rossi");
		corsista.setPrecedentiFormativi(0);

	}

	@Test
	void test() {
		ccBC = new CorsoCorsistaBC();
		cBC = new CorsoBC();
		try {
			corsistaBC = new CorsistaBC();
			cBC.create(corso);
			corsistaBC.create(corsista);

			ccBC.create(cc);

			System.out.println("create");
			ArrayList<Corso> corsi = new ArrayList<>();
			corsi = ccBC.getCorsoMaxfreq();
			for (Corso corso : corsi) {
				System.out.println(corso.toString());
			}
			ArrayList<Corso> corsiIscrivibili = new ArrayList<>();
			corsiIscrivibili = ccBC.getCorsiIscrivibili();
			for (Corso c : corsiIscrivibili) {
				System.out.println(c.toString());
			}
		} catch (DAOException | IOException | ClassNotFoundException exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		cBC = new CorsoBC();
		corsistaBC = new CorsistaBC();
		try {
			cBC.delete(4);
			corsistaBC.delete(4);

			DBAccess.closeConnection();

		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());

		}

	}
}
