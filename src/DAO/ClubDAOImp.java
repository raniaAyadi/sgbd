package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClubDAOImp implements ClubDAO {
	
	public static final String SQL_CREER =" insert into club (label,date_creation) values(?,?);";
	
	public static final String SQL_CONSULTER ="select * from club ;";
	
	public static final String SQL_CONSULTER_BY_LABEL ="select * from club where label = ? ;";
	
	public static final String SQL_FIND_AFTER_YEAR = "select * from club where dateyear(date_creation) >= ? ;";
	
	
	
	@Override
	public void create(Club club) {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false , SQL_CREER, club.getLabel(),club.getDate_creation());
		
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
	public List<Club> findAll() throws ExceptionDAO {
		
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Club> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER, null);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'√©x√©cution du requet pr√©par√©e", e);
		}
		
		l = new ArrayList<Club>();
		try {
			while(result.next()) {
				
				Club cl = (Club) UtileDAO.mapping(result, Club.class.getName());
				l.add(cl);
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
	public Club findByLabel(String label) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Club cl = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_BY_LABEL, label);
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'ÈxÈcution du requet pr√©par√©e", e);
		}
		
		try {
			if(result.next()) 
				cl = (Club) UtileDAO.mapping(result,Club.class.getName());
			else cl = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la rÈcupÈration  du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return cl ;
	
	}

	@Override
	public List<Club> findAllAfterDateCreation(Integer year) {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = UtileDAO.initialiserRequete(c, false, SQL_FIND_AFTER_YEAR, year);
		ResultSet r = null ;
		try {
			r = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, r);
			e.printStackTrace();
		}
		List<Club> l = new ArrayList<Club>();
		try {
			while(r.next()) {
				Club cl = (Club) UtileDAO.mapping(r, Club.class.getName());
				l.add(cl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			UtileDAO.fermeture(c, p, r);
		}
		if(l.isEmpty()) return null ;
		return l ;
		
	}
	

}
