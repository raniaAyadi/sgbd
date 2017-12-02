package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntraineurDAOImp implements EntraineurDAO{
	public static final String SQL_CREATE = "insert into entraineur (num_license) values(?) ;" ;
	public static final String SQL_CONSULTER = "select * from entraineur INNER JOIN coordonnees ON entraineur.id_coordonnees=coordonnees.id_coordonnees;" ;
	public static final String SQL_CONSULTER_BY_NUMLICENSE = "select * from entraineur,coordonnees where entraineur.id_coordonnees=coordonnees.id_coordonnees and num_license =? ;" ;
	
	@Override
	public void create(Entraineur entraineur) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false , SQL_CREATE, entraineur.getNum_license());
		
		new CoordonneesDAOImp().create(entraineur);
		
		try {
			int resultat = p.executeUpdate();
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans l'ÈxÈcution de requete sql", e);
		}
		finally {
			UtileDAO.fermeture(c, p);
		}
	}

	@Override
	public List<Entraineur> findAll() throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER , null);
		ResultSet result = null ;
		List<Entraineur> l = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'√©x√©cution du requet pr√©par√©e", e);
		}
		
		l = new ArrayList<Entraineur>();
		try {
			while(result.next()) {
				Entraineur en = (Entraineur) UtileDAO.mapping(result, Entraineur.class.getName());
				l.add(en);
			}
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la r√©cupp√©ration du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		if(l.isEmpty()) l = null ;
		return l;
	
	}

	@Override
	public Entraineur findByNumLicense(String num_license) throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Entraineur en = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_BY_NUMLICENSE, num_license);
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'ÈxÈcution du requet pr√©par√©e", e);
		}
		
		try {
			if(result.next()) 
				en = (Entraineur) UtileDAO.mapping(result,Entraineur.class.getName());
			else en = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la rÈcupÈration  du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return en ;
		}

}
