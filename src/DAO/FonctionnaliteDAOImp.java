package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FonctionnaliteDAOImp implements FonctinnaliteDAO {

	public static final String SQL_CREATE = "insert into fonctionnalite (label) values(?) ;";
	public static final String SQL_CONSULTER = "select * from fonctionnalite ;";
	public static final String SQL_FIND_BY_ID = "select * from fonctionnalite where id = ?;";
	

	@Override
	public void create(Fonctionnalite fonctionnalie) {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false, SQL_CREATE, fonctionnalie.getLabel());
		try {
			int resultat = p.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans l'éxécutin du requete sql", e);
		} finally {
			UtileDAO.fermeture(c, p);
		}
	}

	@Override
	public List<Fonctionnalite> findAll() throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER, null);
		ResultSet result = null;
		List<Fonctionnalite> l = null;

		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
			throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}

		l = new ArrayList<Fonctionnalite>();
		try {
			while (result.next()) {
				Fonctionnalite fc = (Fonctionnalite) UtileDAO.mapping(result, Fonctionnalite.class.getName());
				l.add(fc);
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
		} finally {
			UtileDAO.fermeture(c, p, result);
		}
		if (l.isEmpty())
			l = null;
		return l;
	}

	

	@Override
	public Fonctionnalite findById(Integer id) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_FIND_BY_ID , id);
		ResultSet result = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		    
		}
		
	Fonctionnalite fo = null; 
		try {
			result.next();
				 fo = (Fonctionnalite) UtileDAO.mapping(result, Fonctionnalite.class.getName());
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		

		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return fo;
	}

}
