package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;


import org.junit.jupiter.api.Order;

import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {

	private static Connection conn;
	private static Corso corso;
	
	@BeforeAll
	static void setUpBeforeClass()  throws Exception {
			conn=DBAccess.getConnection();
			corso=new Corso();
			corso.setIdCorso(1);
			corso.setIdDocente(1);
			corso.setNomeCorso("Analisi");
			corso.setDataInizio(new GregorianCalendar(2022,11,16).getTime());
			corso.setDataFine(new GregorianCalendar(2022,12,16).getTime());
			corso.setCosto(1000.00);
			corso.setCommenti("bho si fa analisi");
			corso.setAula("c1A4");
		
	}
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			
		} catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		DBAccess.closeConnection();
	}

}