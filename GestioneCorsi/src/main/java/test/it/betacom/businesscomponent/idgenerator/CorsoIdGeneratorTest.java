package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;

class CorsoIdGeneratorTest {
	@Test
	void test() {
		try {
			System.out.println(CorsoIdGenerator.getIstance().getNextId());
		} catch (DAOException|IOException|ClassNotFoundException exc) {
			exc.printStackTrace();
			fail("Motivo" + exc.getMessage());
		}
	}

}
