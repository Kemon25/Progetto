package it.betacom.businesscomponent.model;

import java.util.Date;

public class Corso {
	private long idCorso;
	private long idDocente;
	private String nomeCorso;
	private Date dataInizio;
	private Date dataFine;
	private double costo;
	private String commenti;
	private String aula;
	
	
	public long getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(long idCorso) {
		this.idCorso = idCorso;
	}
	public long getIdDocente() {
		return idDocente;
	}
	public void setIdDocente(long idDocente) {
		this.idDocente = idDocente;
	}
	public String getNomeCorso() {
		return nomeCorso;
	}
	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getCommenti() {
		return commenti;
	}
	public void setCommenti(String commenti) {
		this.commenti = commenti;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	@Override
	public String toString() {
		return "Corso [idCorso=" + idCorso + ", idDocente=" + idDocente + ", nomeCorso=" + nomeCorso + ", dataInizio="
				+ dataInizio + ", dataFine=" + dataFine + ", costo=" + costo + ", commenti=" + commenti + ", aula="
				+ aula + "]";
	}
	
	
}