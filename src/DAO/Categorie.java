package DAO;

/*
 * La table CATEGORIE
 */
public class Categorie {
	/*
	 * Proriètées 
	 */
	private Integer id ; //Clé primaire ** ni accessible que par lecture **
	private String niveau ; //Exp : Cadé , Junior , etc ** NOT NULL ** UNIQUE **
	
	/*
	 * Constructeur
	 * Constructeur par défaut : attribut == null 
	 * Constructeur paramétré (niveau)
	 */
	Categorie(){
		this.id = null ;
		this.niveau = null;
	}
	
	Categorie(String niveau){
		this.niveau = niveau ;
	}

	/*
	 * Accesseurs et mutateurs 
	 * id : lecture sulement
	 */
	
	public Integer getId() {
		return id;
	}

	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	//package
	void setId(Integer id) {
		this.id = id;
	}
	
	public void setNiveau(Object niveau) {
		this.niveau = (String) niveau ;
	}
	
	public void setId(Object id) {
		this.id = (Integer) id ;
	}
}
