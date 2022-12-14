package it.betacom.businesscomponent.facade;

import java.util.ArrayList;
import java.util.Date;

import it.betacom.businesscomponent.AdminBC;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.DocenteBC;
import it.betacom.businesscomponent.model.Admin;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;
import it.betacom.businesscomponent.model.Docente;

public class AdminFacade {
	private static AdminFacade adminFacade;
	private AdminBC adminBC;
	private CorsistaBC corsistaBC;
	private CorsoBC corsoBC;
	private CorsoCorsistaBC ccBC;
	private DocenteBC docenteBC;
	
	
	private AdminFacade() {
	}
	
	public static AdminFacade getInstance() {
		if(adminFacade == null) {
			adminFacade = new AdminFacade();
		}
		return adminFacade;
	}
	
	//---------------------------------AdminBC
	public boolean accesso (String username,String password) {
		adminBC = new AdminBC();
		return adminBC.accesso(username, password);
	}
	public Admin getAdmin (String username) {
		adminBC = new AdminBC();
		return adminBC.getAdmin(username);
	}
	
	//---------------------------------DocenteBC
	public Docente getById(long id) {
		docenteBC = new DocenteBC();
		return docenteBC.getById(id);
	}
	public ArrayList<Docente> getAll() {
		docenteBC = new DocenteBC();
		return docenteBC.getAll();
	}
	
	//---------------------------------CorsistaBC
	
	public Corsista createCorsista(Corsista corsista) {
		corsistaBC = new CorsistaBC();
		return corsistaBC.create(corsista);
	}
	
	public void deleteCorsista(long idCorso) {
		corsistaBC = new CorsistaBC();
		corsistaBC.delete(idCorso);
	}
	
	public ArrayList<Corsista> getAllCorsista(){
		corsistaBC = new CorsistaBC();
		return corsistaBC.getAll();
	}
	
	public Corsista getByIdCorsista(long id) {
		corsistaBC = new CorsistaBC();
		return corsistaBC.getById(id);
	}
	
	//---------------------------------CorsoBC
	
	public Corso createCorso(Corso corso) {
		corsoBC = new CorsoBC();
		return corsoBC.create(corso);
	}
	
	public void deleteCorso(long idCorso) {
		corsoBC = new CorsoBC();
		corsoBC.delete(idCorso);
	}
	
	public Date getUltimoCorso() {
		corsoBC = new CorsoBC();
		return corsoBC.getUltimoCorso();
	}
	
	public Corso getByIdCorso (long id) {
		corsoBC = new CorsoBC();
		return corsoBC.getById(id);
	}
	
	public int getMediaCorsi() {
		corsoBC = new CorsoBC();
		return corsoBC.getMediaCorsi();
	}
	
	public int getNumCommenti() {
		corsoBC = new CorsoBC();
		return corsoBC.getNumCommenti();
	}
	
	public ArrayList<Docente> getDocentiMultiCorso(){
		corsoBC = new CorsoBC();
		return corsoBC.getDocentiMultiCorso();
	}
	
	public ArrayList<Corso> getCorsiDisponibili(){
		corsoBC = new CorsoBC();
		return corsoBC.getCorsiDisponibili();
	}
	
	public ArrayList<Corso> getAllCorso() {
		corsoBC = new CorsoBC();
		return corsoBC.getAll();
	}
	
	//---------------------------------CorsoCorsistaBC
	
	public void create(CorsoCorsista corsoCorsista) {
		ccBC = new CorsoCorsistaBC();
		ccBC.create(corsoCorsista);
	}
	
	public ArrayList<Corso> getCorsoByIdCorsista(long idCorsista) {
		ccBC = new CorsoCorsistaBC();
		return ccBC.getCorsiByIdCorsista(idCorsista);
	}
	
	public ArrayList<Corso> getCorsoMaxFreq(){
		ccBC = new CorsoCorsistaBC();
		return ccBC.getCorsoMaxfreq();
	}
	
	public ArrayList<Corso> getCorsiIscrivibili(){
		ccBC = new CorsoCorsistaBC();
		return ccBC.getCorsiIscrivibili();
	}
	
	public int getNumCorsistaByIdCorso(long idCorso) {
		ccBC = new CorsoCorsistaBC();
		return ccBC.getNumCorsistaByIdCorso(idCorso);
	}

	
}











