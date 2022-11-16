package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.AdminBC;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.model.Admin;
import it.betacom.businesscomponent.model.Corsista;

class CorsistaBCTest {

	@Test
	void test() throws DAOException, ClassNotFoundException, IOException {
		CorsistaBC cBC= new CorsistaBC();
		Corsista c = new Corsista();
		
		c.setNome("Stefano");
		c.setCognome("Fossen");
		c.setPrecedentiFormativi(0);
		cBC.create(c);
		
		c.setNome("Stefano1");
		c.setCognome("Fossen");
		c.setPrecedentiFormativi(0);
		cBC.create(c);
		
		c.setNome("Stefano");
		c.setCognome("Fossen1");
		c.setPrecedentiFormativi(0);
		cBC.create(c);

		c.setNome("Stefano1");
		c.setCognome("Fossen1");
		c.setPrecedentiFormativi(0);
		cBC.create(c);
		
		c.setNome("StefanoStefanoStefanoStefanoStefano");
		c.setCognome("Fossen1");
		c.setPrecedentiFormativi(0);
		cBC.create(c);
		
		c.setNome("Stefano");
		c.setCognome("FossenStefanoStefanoStefanoStefanoStefano");
		c.setPrecedentiFormativi(0);
		cBC.create(c);
	}

}
