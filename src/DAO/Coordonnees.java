package DAO;

import java.sql.Date;

public class Coordonnees {
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
	private Date date_naissance;

	public Coordonnees() {
		this.nom = null;
		this.prenom = null;
		this.adresse = null;
		this.date_naissance = null;
	}

	public Coordonnees(String nom, String prenom, String adresse, Date date_naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.date_naissance = date_naissance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId(Object id) {
		this.id = (Integer) id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNom(Object nom) {
		this.nom = (String) nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setPrenom(Object prenom) {
		this.prenom = (String) prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setAdresse(Object adresse) {
		this.adresse = (String) adresse;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public void setDate_naissance(Object date_naissance) {
		this.date_naissance = (Date) date_naissance;
	}

}
