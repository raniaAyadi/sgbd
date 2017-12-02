package DAO;

import java.sql.Date;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
 * La table CHAMPIONNAT
 */
public class Championnat {
	/*
	 * Propriétés
	 */
	private Integer id ; // clé primaire 
	private String niveau ; // Exp : Division 1 , Ligue professionnelle , ect ** NOT NULL ** UNIQUE **
	private Date date_debut ; // ** NOT NULL **
	private Date date_fin ; // **NOT NULL **
	
	public Championnat() {
		this.id = null ;
		this.niveau = null ;
		this.date_debut = null ;
		this.date_fin = null ;
	}

	public Championnat(String niveau, Date date_debut, Date date_fin) {
		super();
		this.niveau = niveau;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}

	public String getNiveau() {
		return niveau;
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	//Surcharge des setters pour les appeller par UtileDAO
	
	public void setId(Object id) {
		this.id =(Integer) id;
	}
	
	public void setDate_debut(Object d) {
		this.date_debut = (Date) d;
	}
	
	public void setDate_fin(Object d) {
		this.date_fin = (Date) d;
	}
	
	public void setNiveau(Object d) {
		this.niveau = (String) d;
	}
	
	//Pour le débogage
	public String toString() {
		return "id = "+getId()+"** niveau = "+getNiveau()+"** date_debut = "+getDate_debut()+"** date_fin = "+getDate_fin() ;
	}
}
