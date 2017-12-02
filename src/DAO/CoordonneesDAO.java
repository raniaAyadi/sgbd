package DAO;

import java.util.List;

public interface CoordonneesDAO {
	
	void create (Coordonnees coordonnees);
	List<Coordonnees> findAll(); 
	Coordonnees findByNom(String niveau); 
}
