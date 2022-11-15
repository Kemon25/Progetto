package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {
	
	@Test
	void testIdGen() {
		try {
			System.out.println(CorsistaIdGenerator.getInstance().getNextId());
		} catch (Exception exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

}
