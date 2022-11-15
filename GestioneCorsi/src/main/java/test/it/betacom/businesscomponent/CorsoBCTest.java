package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.model.Corso;

class CorsoBCTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		Connection conn=DBAConnection
		Corso corso1= new Corso();
		Corso corso2= new Corso();
		
		corso1.setIdCorso(1);
		corso1.setIdDocente(1);
		corso1.setNomeCorso("Algoritmica");
		corso1.setDataInizio(new GregorianCalendar(2022,11,1).getTime());
		corso1.setDataFine(new GregorianCalendar(2022,11,15).getTime());
		corso1.setCosto(500);
		corso1.setCommenti("si fanno gli algoritmi");
		corso1.setAula("A1B1");
		
		corso2.setIdCorso(2);
		corso2.setIdDocente(1);
		corso2.setNomeCorso("Lavori Donneschi");
		corso2.setDataInizio(new GregorianCalendar(2022,11,20).getTime());
		corso2.setDataFine(new GregorianCalendar(2022,12,25).getTime());
		corso2.setCosto(1000);
		corso2.setCommenti("si lavora e si produce");
		corso2.setAula("B2B5");
		
	}

	@Test
	void test() {
		System.out.println(CorsoBC.getFactory().getUltimoCorso());
		fail("Not yet implemented");
	}

}
