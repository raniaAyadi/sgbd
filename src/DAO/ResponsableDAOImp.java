package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsableDAOImp implements ResponsableDAO {

	public static final String SQL_CREATE = "insert into responsable();" ;
	public static final String SQL_CONSULTER  ="select * from responsable INNER JOIN coordonnees on responsable.id_coordonnees=coordonnees.id_coordonnees ;" ;
	public static final String SQL_FIND_BY_ID ="select * from responsable where id = ? ;" ;

	@Override
	public void create(Responsable responsable) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CREATE, null);//on va mettre quoii !!
		new CoordonneesDAOImp().create(responsable);
		//la fonctionnalit� !!! 
		
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

	@Override
	public List<Responsable> findAll() throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p ;
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER , null);
		ResultSet result = null ;
		List<Responsable> l = null ;
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Responsable>();
		try {
			while(result.next()) {
				Responsable res = (Responsable) UtileDAO.mapping(result, Responsable.class.getName());
				l.add(res);
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
	public Responsable findByID(Integer id) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Responsable res = null ;
		p = UtileDAO.initialiserRequete(c, false, SQL_FIND_BY_ID, id);
		
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'�x�cution du requet préparée", e);
		}
		
		try {
			if(result.next()) 
			res  = (Responsable) UtileDAO.mapping(result,Responsable.class.getName());
			else res = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la r�cup�ration  du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return res ;
	}
}
