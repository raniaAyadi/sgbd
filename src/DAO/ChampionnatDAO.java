package DAO;

import java.sql.Date;
import java.util.List ;

public interface ChampionnatDAO {
	//L'ajout
	void create (Championnat championnat);
	
	//Consultation totale du table
	List<Championnat> findAll();
	
	//Mise à jour d'un 
	
	//Selection par un champ unique
	Championnat findByNiveau(String niveau);
	Championnat findById(Integer id); 
	
	//Selection par des dates
	List<Championnat> findAllByDateDebut(Date dateDebut);
	List<Championnat> findAllByDateFin(Date dateFin);
	List<Championnat> findAfterDateDebut(Date dateInf);
	List<Championnat> findBeforeDateFin(Date dateSup);
	List<Championnat> findBetween(Date dateInf , Date dateSup);
}
