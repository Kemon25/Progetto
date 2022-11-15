package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {
	private static CorsoBC corso;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corso = new CorsoBC();
		Corso corso1 = new Corso();
		Corso corso2 = new Corso();
		Corso corso3 = new Corso();

		corso1.setIdCorso(1);
		corso1.setIdDocente(1);
		corso1.setNomeCorso("Algoritmica");
		corso1.setDataInizio(new GregorianCalendar(2022, 11, 1).getTime());
		corso1.setDataFine(new GregorianCalendar(2022, 12, 23).getTime());
		corso1.setCosto(500);
		corso1.setCommenti("si fanno gli algoritmi");
		corso1.setAula("A1B1");
		corso.create(corso1);

		corso2.setIdCorso(2);
		corso2.setIdDocente(1);
		corso2.setNomeCorso("GPO");
		corso2.setDataInizio(new GregorianCalendar(2022, 11, 1).getTime());
		corso2.setDataFine(new GregorianCalendar(2022, 10, 25).getTime());
		corso2.setCosto(1000);
		corso2.setCommenti("Gestione D'impresa");
		corso2.setAula("B2B5");
		corso.create(corso2);

		corso3.setIdCorso(3);
		corso3.setIdDocente(1);
		corso3.setNomeCorso("java");
		corso3.setDataInizio(new GregorianCalendar(2022, 9, 26).getTime());
		corso3.setDataFine(new GregorianCalendar(2023, 1, 13).getTime());
		corso3.setCosto(1000);
		corso3.setCommenti("java EE");
		corso3.setAula("B4E3");
		corso.create(corso3);

	}

	@Test
	@Order(1)
	void getUltimoCorsotest() throws ClassNotFoundException, DAOException, SQLException, IOException {
		try {
			corso = new CorsoBC();
			Date data = corso.getUltimoCorso();
			System.out.println(data);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}

	}

	@Test
	@Order(2)
	void getMedia() throws ClassNotFoundException, IOException {
		try {
			corso = new CorsoBC();
			int media = corso.getMediaCorsi();
			System.out.println("La durata media dei corsi è di " + media + " giorni");

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(3)
	void getNumCommenti() throws ClassNotFoundException, IOException {
		try {
			corso = new CorsoBC();
			System.out.println(corso.getNumCommenti());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(4)
	void getDocentiMultiCorso() throws ClassNotFoundException, IOException {
		try {
			corso = new CorsoBC();
			System.out.println(corso.getDocentiMultiCorso());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(5)
	void getCorsiDisponibili() throws ClassNotFoundException, IOException {
		try {
			corso = new CorsoBC();
			System.out.println(corso.getCorsiDisponibili());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corso = new CorsoBC();
			corso.delete(1);
			corso.delete(2);
			corso.delete(3);
			System.out.println("Corsi eliminati");

		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());
		} finally {
			DBAccess.closeConnection();
		}

	}

}
