package it.betacom.businesscomponent.model;

public class CorsoCorsista {
	private int idCorso;
	private int idCorsista;
	
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public int getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(int idCorsista) {
		this.idCorsista = idCorsista;
	}
	
	@Override
	public String toString() {
		return "CorsoCorsista [idCorso=" + idCorso + ", idCorsista=" + idCorsista + "]";
	}
	
}
