package it.betacom.businesscomponent.model;

public class CorsoCorsista {
	private long idCorso;
	private long idCorsista;
	
	public long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}
	public long getIdCorsista() {
		return idCorsista;
	}
	public void setIdCorsista(long idCorsista) {
		this.idCorsista = idCorsista;
	}
	
	@Override
	public String toString() {
		return "CorsoCorsista [idCorso=" + idCorso + ", idCorsista=" + idCorsista + "]";
	}
	
}
