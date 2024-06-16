package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UtenteDAO implements UtenteDAOInterfaccia {
	
	
	
	private static final String INSERT_SQL = "INSERT INTO USER ( Nome, Cognome, ID, Indirizzo, Email, Psw, IsAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BY_KEY_SQL = "SELECT * FROM USER WHERE ID = ?";
    private static final String DELETE_BY_KEY_SQL = "DELETE FROM USER WHERE ID = ?";
    private static final String UPDATE_SQL = "UPDATE USER SET Nome = ?, Cognome = ?, Indirizzo = ?, Email = ?, Psw = ?, IsAdmin = ? WHERE ID = ?";
    private static final String RETRIEVE_ALL="SELECT * FROM USER";
   

    
    public boolean doSave(UtenteDTO user) throws SQLException {
        try (Connection con = DriverManagerConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SQL)) {
            ps.setInt(1, user.getID());
            ps.setString(2, user.getNome());
            ps.setString(3, user.getCognome());
            ps.setString(4, user.getIndirizzo());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPsw());
            ps.setInt(7, user.getIsAdmin());
            int rowsaffected=ps.executeUpdate();
            return rowsaffected>0;
        }
    }

    public UtenteDTO doRetrieveByKey(int id) throws SQLException {
        try (Connection con = DriverManagerConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_KEY_SQL)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UtenteDTO(
                    rs.getInt("ID"),
                    rs.getString("Nome"),
                    rs.getString("Cognome"),
                    rs.getString("Indirizzo"),
                    rs.getString("Email"),
                    rs.getString("Psw"),
                    rs.getInt("IsAdmin")
                );
            }
        }
        return null;
    }

    public boolean doDeleteByKey(int id) throws SQLException {
        try (Connection con = DriverManagerConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_BY_KEY_SQL)) {
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
    }

    
    public void doUpdate(UtenteDTO user) throws SQLException { //aggiorno user con quel preciso id passando già tutti i dati aggiornati
        try (Connection con = DriverManagerConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_SQL)) {
            ps.setString(1, user.getNome());
            ps.setString(2, user.getCognome());
            ps.setString(3, user.getIndirizzo());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPsw());
            ps.setInt(6, user.getIsAdmin());
            ps.setInt(7, user.getID());
            ps.executeUpdate();
        }
    }
    
    
    public ArrayList<UtenteDTO> doRetrieveAll() throws SQLException {
    	try(Connection con=DriverManagerConnectionPool.getConnection();
    			PreparedStatement ps= con.prepareStatement(RETRIEVE_ALL)){
    		ResultSet rs=ps.executeQuery();
    		ArrayList<UtenteDTO> listaUtenti=new ArrayList<>();

    		while(rs.next()) {
    			UtenteDTO u=new UtenteDTO(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome"),  rs.getString("indirizzo"), rs.getString("email"), rs.getString("psw"), rs.getInt("isAdmin"));
    			listaUtenti.add(u);
    		}
    		return listaUtenti;
    	}
    }

	
}


