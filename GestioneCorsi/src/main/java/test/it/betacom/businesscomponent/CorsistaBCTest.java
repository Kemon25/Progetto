package test.it.betacom.businesscomponent;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {
	private static CorsistaBC cBC;
	private static CorsistaBC cBC2;
	private static CorsistaBC cBC3;
	private static Corsista c;
	private static Corsista c1;	
	private static Corsista c2;	
	
	@BeforeAll
	static void setUpBeforeClass() {
		cBC = new CorsistaBC();
		
		c = new Corsista();
		c1 = new Corsista();
		c2 = new Corsista();
		
		c.setNome("Stefano");
		c.setCognome("Fossen");
		c.setPrecedentiFormativi(0);
		
		c1.setNome("Stefano1");
		c1.setCognome("Fossen");
		c1.setPrecedentiFormativi(0);
		
		c2.setNome("StefanoStefanoStefanoStefanoStefano");
		c2.setCognome("Fossen");
		c2.setPrecedentiFormativi(1);
	}
	
	@Test
	@Order(1)
	void testCreate() {
		if(cBC.create(c) != null)
			System.out.println("Nome e cognome nel formato corretto! Corsista creato");
		else
			System.out.println("Nome o cognome non nel formato corretto! Corsista non creato");
		
		if(cBC.create(c1) != null)
			System.out.println("Nome e cognome nel formato corretto! Corsista creato");
		else
			System.out.println("Nome o cognome non nel formato corretto! Corsista non creato");
		
		if(cBC.create(c2) != null)
			System.out.println("Nome e cognome nel formato corretto! Corsista creato");
		else
			System.out.println("Nome o cognome non nel formato corretto! Corsista non creato");
	}
	
	@Test
	@Order(2)
	void testGetAll() {
		cBC2 = new CorsistaBC();
		System.out.println(cBC2.getAll());
	}
	
	@Test
	@Order(3)
	void testGetById() {
		cBC3 = new CorsistaBC();
		System.out.println(cBC3.getById(2));
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		cBC.delete(c.getId());
	}

}
