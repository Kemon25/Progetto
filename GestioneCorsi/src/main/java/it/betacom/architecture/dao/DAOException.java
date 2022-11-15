package it.betacom.architecture.dao;

import java.sql.SQLException;

public class DAOException extends SQLException{

	private static final long serialVersionUID = -5756853338649595937L;

	private final static int ORA1017 = 1017; 
	private final static int ORA00017 = 00017; 
	private final static int ORA17002 = 17002;
	private final static int ORA00001 = 0;
	private final static int ORA00026=00026;
	
	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}
	
	public DAOException(SQLException sql) {
		String chiave = "";
		if(sql != null) {
			switch(sql.getErrorCode()) {
			case ORA1017:
				chiave = "Credenziali di accesso al db errate";
				log(sql);
				break;
			case ORA17002:
				chiave = "Errore di Oracle IO";
				log(sql);
				break;
			case ORA00001:
				chiave = "Vincolo di tabella violato";
				log(sql);
				break;
			case ORA00017:
				chiave = "Ã¨ richiesta una sessione per impostare l'evento traccia";
				log(sql);
				break;
			case ORA00026:
				chiave = "ID sessione mancante o non valido";
				log(sql);
				break;
			default:
				chiave = "Eccezione SQL non prevista";
				log(sql);
			}
		}
		message = chiave;
	}
	
	private void log(SQLException sql) {
		sql.printStackTrace();
		System.err.println("Motivo: "+sql.getMessage());
		System.err.println("Codice: "+sql.getErrorCode());
		System.err.println("Stato app: "+sql.getSQLState());
		System.err.println("Causa: "+sql.getCause());
	}

}