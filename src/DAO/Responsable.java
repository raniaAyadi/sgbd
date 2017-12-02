package DAO;

public class Responsable extends Coordonnees {
	private Integer id  ;
	private Club Resclub;
	private Fonctionnalite ResFonc;

	public Responsable() {
		super();
	}
	

	public Responsable(Club resclub, Fonctionnalite resFonc) {
		super();
		Resclub = resclub;
		ResFonc = resFonc;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
