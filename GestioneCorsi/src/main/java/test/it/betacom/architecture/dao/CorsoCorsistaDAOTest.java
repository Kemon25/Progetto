package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dao.DAOException;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Corsista corsista;
	private static CorsoCorsista corsoCorsista;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setIdCorso(2);
		corso.setIdDocente(1);
		corso.setNomeCorso("Fisica");
		corso.setDataInizio(new GregorianCalendar().getTime());
		corso.setDataFine(new GregorianCalendar(2022, 11, 4).getTime());
		corso.setCosto(1200.13);
		corso.setCommenti("ciao");
		corso.setAula("A1");
		
		
		corsoCorsista = new CorsoCorsista();
		corsoCorsista.setIdCorsista(1);
		corsoCorsista.setIdCorso(1);
		
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			CorsoCorsistaDAO.getFactory().create(conn, corsoCorsista);
			
		} catch (DAOException e) {
			e.printStackTrace();		
			fail("Motivo: "+ e.getMessage());
			
		}	
	}
	
	@Test
	@Order(2)
	void testGet() {
		ArrayList<Corso> l = new ArrayList<Corso>();
		int num;
		try {
			l = CorsoCorsistaDAO.getFactory().getCorsiByIdCorsista(conn, 1);
			num = CorsoCorsistaDAO.getFactory().getNumCorsistaByIdCorso(conn, 1);
			
		} catch (DAOException e) {
			e.printStackTrace();		
			fail("Motivo: "+ e.getMessage());
			
		}	
		
	}
	
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		try {
			DBAccess.closeConnection();
			CorsoDAO.getFactory().delete(conn, 2);
			CorsistaDAO.getFactory().delete(conn, corsista);
		
			
		}	catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
			
		}
	}
	
}
