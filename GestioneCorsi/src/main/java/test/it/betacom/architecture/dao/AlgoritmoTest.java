package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.security.Algoritmo;


class AlgoritmoTest {

	@Test
	void test() {
		String pass = Algoritmo.convertiMD5("pass");
		assertNotNull(pass);
		System.out.println(pass);
	}

}