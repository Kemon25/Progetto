package test.it.betacom.businesscomponent.validate;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.validate.Validazione;

class ValidazioneTest {
	private static Validazione validazione;
	private static String nome;
	private static String nome1;
	private static String nome2;
	private static String nome3;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		nome = "Angelo  ";
		nome1 = "Ange5lo";
		nome2 = "Angel&o";
		nome3 = "AngeloAngeloAngeloAngeloAngeloaltro";
	}


	@Test
	void test() {
		try {
			validazione = Validazione.getFactory();
			System.out.println(validazione.nomeCorsista(nome));
			System.out.println(validazione.nomeCorsista(nome1));
			System.out.println(validazione.nomeCorsista(nome2));
			System.out.println(validazione.nomeCorsista(nome3));
		} catch (Exception exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}
}
