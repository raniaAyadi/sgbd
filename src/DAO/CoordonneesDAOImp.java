package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoordonneesDAOImp implements CoordonneesDAO {

	public static final String SQL_CREATE = "insert into coordonnees (nom,prenom,adresse,date_naissance) values(?,?,?,?) ;" ;
	public static final String SQL_CONSULTER = "select * from coordonnees ;" ;
	public static final String SQL_CONSULTER_BY_NOM = "select * from coordonnees where nom = ? ;" ;
	public static final String SQL_FIND_BY_ID ="select * from coordonnees where id= ?;";
	@Override
	public void create(Coordonnees coordonnees) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false, SQL_CREATE, coordonnees.getNom(),coordonnees.getPrenom(), coordonnees.getAdresse(), coordonnees.getDate_naissance());

		try {
			int resultat = p.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans l'éxécutin du requete sql", e);
		}
		finally {
			UtileDAO.fermeture(c,p);
		}
	

	}

	@Override
	public List<Coordonnees> findAll() throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER , null);
		ResultSet result = null ;
		List<Coordonnees> l = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Coordonnees>();
		try {
			while(result.next()) {
				Coordonnees co = (Coordonnees) UtileDAO.mapping(result, Coordonnees.class.getName());
				l.add(co);
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		if(l.isEmpty()) l = null ;
		return l;
}

	@Override
	public Coordonnees findByNom(String nom) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Coordonnees  co = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_BY_NOM, nom);
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'�x�cution du requet préparée", e);
		}
		
		try {
			if(result.next()) 
				co = (Coordonnees) UtileDAO.mapping(result,Coordonnees.class.getName());
			else co = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la r�cup�ration  du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return co ;
	}

}
