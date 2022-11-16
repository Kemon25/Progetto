package test.it.betacom.businesscomponent;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DAOException;
import it.betacom.businesscomponent.AdminBC;
import it.betacom.businesscomponent.model.Admin;

class AdminBCTest {

	@Test
	void test() throws DAOException, ClassNotFoundException, IOException {

		AdminBC aBC = new AdminBC();
		Admin a = new Admin();
		a.setUsername("admin");
		a.setPassword("pass");

		if (aBC.accesso(a.getUsername(), a.getPassword()))
			System.out.println("La password inserita è corretta");
		else
			System.out.println("Password o admin errati");

		System.out.println(aBC.getAdmin(a.getUsername()));

	}

}
