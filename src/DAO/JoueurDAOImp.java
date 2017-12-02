package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurDAOImp implements JoueurDAO {
	
	public static final String SQL_CREATE = "insert into joueur (num_license) values(?) ;" ;
	public static final String SQL_CONSULTER = "select * from joueur INNER JOIN coordonnees ON joueur.id_coordonnees=coordonnees.id_coordonnees;" ;
	public static final String SQL_CONSULTER_BY_NUMLICENSE = "select * from joueur,coordonnees where joueur.id_coordonnees=coordonnees.id_coordonnees and num_license =? ;" ;
	
	@Override
	public void create(Joueur joueur) throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false , SQL_CREATE, joueur.getNum_license());
		
		new CoordonneesDAOImp().create(joueur);
		
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
	public List<Joueur> findAll() throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER , null);
		ResultSet result = null ;
		List<Joueur> l = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'√©x√©cution du requet pr√©par√©e", e);
		}
		
		l = new ArrayList<Joueur>();
		try {
			while(result.next()) {
				Joueur jo = (Joueur) UtileDAO.mapping(result, Joueur.class.getName());
				l.add(jo);
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
	public Joueur findByNumLicense(String num_license) throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Joueur jo = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_BY_NUMLICENSE, num_license);
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'ÈxÈcution du requet pr√©par√©e", e);
		}
		
		try {
			if(result.next()) 
				jo = (Joueur) UtileDAO.mapping(result,Joueur.class.getName());
			else jo = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la rÈcupÈration  du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return jo ;
		}

}
