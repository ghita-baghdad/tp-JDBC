/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.beans.Client;
import ma.beans.Service;
import ma.connexion.Connexion;
import ma.dao.IDao;

/**
 *
 * @author Lachgar
 */
public class ClientService implements IDao<Client>{
    private ServiceService ss;

    public ClientService() {
        ss = new ServiceService();
    }
    

  
    public boolean create(Client o) {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            
            String maxIdQuery = "SELECT MAX(id) FROM client";
            PreparedStatement maxIdStatement = Connexion.getConnection().prepareStatement(maxIdQuery);
            ResultSet resultSet = maxIdStatement.executeQuery();
            
           int maxClientId = 0;
        
        // Vérifier s'il y a un résultat
        if (resultSet.next()) {
            maxClientId = resultSet.getInt(1);
        }
        
        // Calculer le prochain ID client
        int newClientId = maxClientId + 1;
        
        // Requête SQL pour insérer le nouveau client 
          
            String req = "insert into client(id, nom, prenom, date, service ) values (?, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1,newClientId);
            ps.setString(2, o.getNom());
             ps.setString(3, o.getPrenom());
            ps.setDate(4, new Date(o.getDate().getTime()));
            ps.setInt(5, o.getService().getId());
            if(ps.executeUpdate() == 1)
                return true;
        resultSet.close();
        maxIdStatement.close();
        ps.close();
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un client:" +ex.getMessage());
        }
        return false;
    }
    

      public boolean update(Client o) {
                
    try {
        StringBuilder req = new StringBuilder("UPDATE client SET");
        // Check and append fields that are not null or empty
        if (o.getNom() != null && !o.getNom().isEmpty())
            req.append(" nom = ?,");
        if (o.getPrenom() != null && !o.getPrenom().isEmpty())
            req.append(" prenom = ?,");
        if (o.getDate() != null)
            req.append(" date = ?,");
        if (o.getService() != null)
            req.append(" service = ?,");
        // Remove the trailing comma
        req.deleteCharAt(req.length() - 1);
        req.append(" WHERE id = ?");
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req.toString());

        int index = 1;
        if (o.getNom() != null && !o.getNom().isEmpty())
            ps.setString(index++, o.getNom());
        if (o.getPrenom() != null && !o.getPrenom().isEmpty())
            ps.setString(index++, o.getPrenom());
        if (o.getDate() != null)
            ps.setDate(index++, new Date(o.getDate().getTime()));
        if (o.getService() != null)
            ps.setInt(index++, o.getService().getId());

        // Set the ID
        ps.setInt(index, o.getId());

        if (ps.executeUpdate() == 1)
            return true;
    } catch (SQLException ex) {
        System.err.println("Error updating client: " + ex.getMessage());
    }
    return false;

}
 
  
    
    public boolean delete(Client o) {
        String req = "delete from client where id = "+ o.getId();
        try {
            Statement st = Connexion.getConnection().createStatement();
            st.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur de suppression d'un client:" +ex.getMessage());
        }
        return false;
    }

    @Override
    public Client findById(int id) {
        Client client = null;
        ResultSet rs = null;
        String req = "select * from client where id = "+id;
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            if (rs.next()){
              client = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date"), ss.findById(rs.getInt("service")));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findById client:" +ex.getMessage());
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        ResultSet rs = null;
        String req = "select * from client";
        try {
            Statement st = Connexion.getConnection().createStatement();
            rs = st.executeQuery(req);
            while (rs.next()){
              clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date"), ss.findById(rs.getInt("service"))));
            }
        } catch (SQLException ex) {
            System.out.println("Erreur findAll client:" +ex.getMessage());
        }
        return clients;
            
    }

    public void update(Client findById, String text, String text0, java.util.Date date, Service serv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}


    

