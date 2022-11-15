package it.betacom.architecture.dao;

public interface DAOConstants {

	// ------Admin
	String SELECT_ADMIN_ID = "select * from admin where username = ?";
	// ------Docente
	String SELECT_DOCENTE_ID = "select * from docente where id_docente = ?";

	// ------Corso
	String SELECT_CORSO = "select * from corso";
	String SELECT_CORSO_ID = "select * from corso where id_corso = ?";
	String SELECT_CORSO_DOCENTE_ID = "select * from corso where id_docente = ?";
	String DELETE_CORSO = "delete from corso where id_corso = ?";

	// ------Corsista
	String SELECT_CORSISTA = "select * from corsista";
	String SELECT_CORSISTA_ID = "select * from corsista where id_corsista = ?";
	String DELETE_CORSISTA = "delete from corsista where id_corsista = ?";

	// ------Corso_Corsista
	String SELECT_CORSOCORSISTA = "select * from corso_corsista";
	String SELECT_CORSO_CORSISTA_ID = "select * from corso_corsista where id_corsista = ?";
	String SELECT_NCORSISTA_CORSO_ID = "select count(*) from corso_corsista where id_corso = ?";

	// sequenze
	String SELECT_CORSOSEQ = "select corso_seq.nextval from dual";
	String SELECT_CORSISTASEQ = "select corsista_seq.nextval from dual";

}
