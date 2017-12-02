package DAO;

public class Fonctionnalite {
	private Integer id;
	private String label;

	public Fonctionnalite() {
		super();
		this.label = null;
	}

	public Fonctionnalite(String label) {
		super();
		this.label = label;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
