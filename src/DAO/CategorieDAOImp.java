/**
 * 
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author user
 *
 */
public class CategorieDAOImp implements CategorieDAO {

	
	public static final String SQL_CREATE = "insert into categorie (niveau) values(?) ;" ;
	public static final String SQL_CONSULTER = "select * from categorie ;" ;
	public static final String SQL_FIND_BY_NIVEAU = "select * from categorie where niveau = ? ;" ;
	public static final String SQL_FIND_BY_ID ="select * from categorie where id= ?;";
	
	
	
	@Override
	public void create(Categorie categorie) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CREATE, categorie.getNiveau());
		try {
			int resultat = p.executeUpdate();
		}
		catch(SQLException e) {
			throw new ExceptionDAO("Erreur dans l'éxécutin du requete sql", e);
		}
		finally {
			UtileDAO.fermeture(c, p);
		}

	}

	/* (non-Javadoc)
	 * @see DAO.CategorieDAO#findAll()
	 */
	@Override
	public List<Categorie> findAll() {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER , null);
		ResultSet result = null ;
		List<Categorie> l = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Categorie>();
		try {
			while(result.next()) {
				Categorie ch = (Categorie) UtileDAO.mapping(result, Categorie.class.getName());
				l.add(ch);
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

	/* (non-Javadoc)
	 * @see DAO.CategorieDAO#findByNiveau(java.lang.String)
	 */
	@Override
	public Categorie findByNiveau(String niveau) throws ExceptionDAO{
		
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_FIND_BY_NIVEAU , niveau);
		ResultSet result = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		    
		}
		
		Categorie ch = null; 
		try {
			result.next();
				 ch = (Categorie) UtileDAO.mapping(result, Categorie.class.getName());
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		

		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return ch;
	}

	@Override
	public Categorie findById(Integer id) throws ExceptionDAO {
		
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
		
		Categorie ch = null; 
		try {
			result.next();
				 ch = (Categorie) UtileDAO.mapping(result, Categorie.class.getName());
			
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		

		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return ch;	
	}
}
	
	

