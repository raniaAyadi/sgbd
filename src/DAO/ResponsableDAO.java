package DAO;

import java.util.List;

public interface ResponsableDAO {
	void create (Responsable responsable);
	List<Responsable> findAll(); 
	//Consultation par un champ unique
	Responsable findByID(Integer id); 

}
