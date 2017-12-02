package DAO;

import java.util.List;

public interface FonctinnaliteDAO {
	void create (Fonctionnalite fonctionnalie);
	List<Fonctionnalite> findAll(); 
	Fonctionnalite findById(Integer id); 
	
}
