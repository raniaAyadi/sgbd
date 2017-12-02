
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChampionnatDAOImp implements ChampionnatDAO {

	private static final String SQL_CREER = "insert into championnat"
			                        +"(niveau,date_debut,date_fin)"
			                        +"values(?,?,?)";
	
	private static final String SQL_CONSULTER = "select *"
			                                  + "from championnat ; " ;
	
	private static final String SQL_CONSULTER_NIVEAU = "select * "
			                                         + "from championnat "
			                                         + "where niveau = ? ;" ;  
	
	private static final String SQL_CONSULTER_DATE_DEBUT = "select * "
			                                             + "from championnat "
			                                             + "where date_debut = ? ;" ;
	
	private static final String SQL_CONSULTER_DATE_FIN = "select * "
                                                         + "from championnat "
                                                         + "where date_fin = ? ;" ;
	
	private static final String SQL_CONSULTER_APRES_DATE_DEBUT = "select * "
			                                                    + "from championnat "
			                                                    + "where datediff(date_debut,?) >= 0 ;" ;
	
	private static final String SQL_CONSULTER_AVANT_DATE_FIN =    "select * "
                                                                + "from championnat "
                                                                + "where datediff(date_fin,?) <= 0 ;" ;
	
	
	private static final String SQL_CONSULTER_ENTRE =        "select * "
			                                               + "from championnat "
			                                               + "where datediff(date_debut,?) >= 0 "
			                                               + "and datediff(date_fin,?) <= 0 ;" ;
	
	
	public static final String SQL_FIND_BY_ID ="select * from championnat where id= ?;";
	
	public ChampionnatDAOImp() {
		super();
	}
	
	@Override
	public void create(Championnat championnat) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null;
		p = UtileDAO.initialiserRequete(c, false, SQL_CREER, championnat.getNiveau(),championnat.getDate_debut(),championnat.getDate_fin());
	
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
	public List<Championnat> findAll() throws ExceptionDAO{
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER, null);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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
	
	@Override
	public Championnat findByNiveau(String niveau) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Championnat ch = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_NIVEAU, niveau);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		try {
			if(result.next()) ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
			else ch = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return ch ;
		
	}

	@Override
	public List<Championnat> findAfterDateDebut(Date dateInf) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_APRES_DATE_DEBUT, dateInf);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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

	@Override
	public List<Championnat> findBeforeDateFin(Date dateSup) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_APRES_DATE_DEBUT, dateSup);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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

	@Override
	public List<Championnat> findAllByDateDebut(Date dateDebut) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_DATE_DEBUT, dateDebut);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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

	@Override
	public List<Championnat> findAllByDateFin(Date dateFin) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_DATE_FIN, dateFin);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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

	@Override
	public List<Championnat> findBetween(Date dateInf, Date dateSup) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		List<Championnat> l = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_CONSULTER_ENTRE, dateInf,dateSup);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		l = new ArrayList<Championnat>();
		try {
			while(result.next()) {
				Championnat ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
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

	@Override
	public Championnat findById(Integer id) throws ExceptionDAO {
		Connection c = UtileDAO.etablirConnexion();
		PreparedStatement p = null ;
		ResultSet result = null ;
		Championnat ch = null ;
		
		p = UtileDAO.initialiserRequete(c, false, SQL_FIND_BY_ID, id);
		try {
			result = p.executeQuery();
		} catch (SQLException e) {
			UtileDAO.fermeture(c, p, result);
		    throw new ExceptionDAO("Erreur dans l'éxécution du requet préparée", e);
		}
		
		try {
			if(result.next()) ch =(Championnat) UtileDAO.mapping(result,Championnat.class.getName());
			else ch = null ;
		} catch (SQLException e) {
			throw new ExceptionDAO("Erreur dans la récuppération du resuletSet", e);
			}
		finally {
			UtileDAO.fermeture(c, p, result);
		}
		return ch ;
	}

	

}

