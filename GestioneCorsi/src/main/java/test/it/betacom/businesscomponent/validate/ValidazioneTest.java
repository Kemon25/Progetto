package test.it.betacom.businesscomponent.validate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
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
		validazione = Validazione.getFactory();

		nome = "Angelo  ";
		nome1 = "Ange5lo";
		nome2 = "Angel&o";
		nome3 = "AngeloAngeloAngeloAngeloAngeloaltro";
	}

	@Test
	@Order(1)
	void vString() {
		try {
			assertEquals(true, validazione.nomeCorsista(nome));
			assertEquals(false, validazione.nomeCorsista(nome1));
			assertEquals(false, validazione.nomeCorsista(nome2));
			assertEquals(false, validazione.nomeCorsista(nome3));
			assertEquals(false, validazione.nomeCorsista(null));
		} catch (Exception exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(2)
	void diffDateCorso() {
		GregorianCalendar calInizio = new GregorianCalendar();
		calInizio.set(Calendar.YEAR, 2000);
		calInizio.set(Calendar.MONTH, 11);
		calInizio.set(Calendar.DAY_OF_MONTH, 13);

		GregorianCalendar calFine = new GregorianCalendar();
		calFine.set(Calendar.YEAR, 2000);
		calFine.set(Calendar.MONTH, 11);
		calFine.set(Calendar.DAY_OF_MONTH, 13);
		assertEquals(false, validazione.dateCorso(calInizio.getTime(), calFine.getTime()));

		calFine.set(Calendar.YEAR, 2000);
		calFine.set(Calendar.MONTH, 11);
		calFine.set(Calendar.DAY_OF_MONTH, 17);
		assertEquals(true, validazione.dateCorso(calInizio.getTime(), calFine.getTime()));

		calFine.set(Calendar.YEAR, 2003);
		calFine.set(Calendar.MONTH, 11);
		calFine.set(Calendar.DAY_OF_MONTH, 13);
		assertEquals(true, validazione.dateCorso(calInizio.getTime(), calFine.getTime()));

		assertEquals(false, validazione.dateCorso(null, calFine.getTime()));

	}

	@Test
	@Order(3)
	void commenti() {
		assertEquals(true, validazione.commenti(null));
		assertEquals(true, validazione.commenti(null));
		assertEquals(false, validazione.commenti(
				"12345jsdbvjffbajdbiefabsfeagsrdhtafegsrteqrwewqweqwegwteherwehweryt3weygrsefasgrhdtrgeawetyhtewyerwrytwrqtjhyrtewwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"));
	}

	@Test
	@Order(4)
	void aula() {
		try {
			assertEquals(true, validazione.aulaCorso("aaaa"));
			assertEquals(false, validazione.aulaCorso("aaaaa"));
			assertEquals(false, validazione.aulaCorso("aaa"));
			assertEquals(true, validazione.aulaCorso("aaa1"));
			assertEquals(false, validazione.aulaCorso("aaa&"));
			assertEquals(false, validazione.aulaCorso(null));
		} catch (Exception exc) {
			fail("Motivo: " + exc.getMessage());
		}
	}

	@Test
	@Order(5)
	void prezzo() {
		assertEquals(true, validazione.prezzo(123456.12));
		assertEquals(true, validazione.prezzo(123456.123));
		assertEquals(false, validazione.prezzo(1234567.12));
		assertEquals(true, validazione.prezzo(0));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

	}
}
