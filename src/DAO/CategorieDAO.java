package DAO;

import java.util.List;

public interface CategorieDAO {
	void create (Categorie categorie);
	List<Categorie> findAll(); 
	//Consultation par un champ unique
	Categorie findByNiveau(String niveau); 
	Categorie findById(Integer id); 
	
}
