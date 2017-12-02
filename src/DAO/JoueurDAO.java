package DAO;

import java.util.List;

public interface JoueurDAO {
	
	void create (Joueur joueur);
	
	//Consultation totale du table
	List<Joueur> findAll();
	
	//Mise à jour d'un 
	
	//Selection par un champ unique
	Joueur findByNumLicense(String num_license);
}
