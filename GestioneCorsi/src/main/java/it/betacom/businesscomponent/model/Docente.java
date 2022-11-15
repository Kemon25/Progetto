package it.betacom.businesscomponent.model;

public class Docente {
	
	private long id;
	private String nome;
	private String cognome;
	private String cv;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	@Override
	public String toString() {
		return "Docente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", cv=" + cv + "]";
	}
	
	
	
}
