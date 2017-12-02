package DAO;

import java.sql.Date;
import java.util.List;

public interface ClubDAO {
	//L'ajout
	void create (Club club );
	
	//Consultation totale du table
	List<Club> findAll();
	
	//Mise à jour d'un 
	
	//Selection par un champ unique
	Club findByLabel(String label);
	Club findById(Integer id);
	
	List<Club> findAllAfterDateCreation (Integer year);
}
