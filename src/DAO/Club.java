package DAO;

import java.sql.Date;

public class Club {

	private Integer id;
	private String label;
	private Date date_creation;
	public Club(String label, Date date_creation) {
		super();
		this.label = label;
		this.date_creation = date_creation;
	}
	
	
	public Club () {
		this.id = null; 
		this.label = null; 
		this.date_creation = null;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Object id) {
		this.id = (Integer) id;
	}


	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public void setLabel(Object label) {
		this.label = (String) label;
	}
	
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	

	public void setDate_creation(Object date_creation) {
		this.date_creation = (Date) date_creation;
	}
	
	
}
