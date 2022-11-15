package it.betacom.businesscomponent.model;

public class Corsista {
	private long id;
	private String nome;
	private String cognome;
	private int precedentiFormativi;
	
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
	public int getPrecedentiFormativi() {
		return precedentiFormativi;
	}
	public void setPrecedentiFormativi(int precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}
	
	@Override
	public String toString() {
		return "Corsista [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", precedentiFormativi="
				+ precedentiFormativi + "]";
	}
}
