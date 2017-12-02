package DAO;

public class Entraineur extends Coordonnees{

	private Integer num_license;

	
	public Entraineur ()
	{
		this.num_license = null;
	}
	public Entraineur(Integer num_license) {
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
