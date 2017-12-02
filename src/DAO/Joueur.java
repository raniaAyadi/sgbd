package DAO;

public class Joueur extends Coordonnees{
	private Integer num_license;
	public Coordonnees cord;

	
	public Joueur ()
	{
		this.num_license = null;
		this.cord = null;
	}
	public Joueur(Integer num_license) {
		super();
		this.num_license = num_license;
	}
	public Integer getNum_license() {
		return num_license;
	}
	public void setNum_license(Integer num_license) {
		this.num_license = num_license;
	}
	
	public void setNum_license(Object num_license) {
		this.num_license = (Integer) num_license;
	}
	
}

