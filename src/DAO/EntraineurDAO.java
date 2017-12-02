package DAO;

import java.util.List;

public interface EntraineurDAO {
	
	
	void create (Entraineur entraineur);
	List<Entraineur> findAll();
	
	//Selection par un champ unique
	Entraineur findByNumLicense(String num_license);
}
