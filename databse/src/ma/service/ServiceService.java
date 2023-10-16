/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.beans.Service;
import ma.connexion.Connexion;
import ma.dao.IDao;

/**
 *
 * @author Lachgar
 */
public class ServiceService implements IDao<Service>{

    @Override
    public boolean create(Service o) {
        
        try {
            
            String maxIdQuery = "SELECT MAX(id) FROM service";
            PreparedStatement maxIdStatement = Connexion.getConnection().prepareStatement(maxIdQuery);
            ResultSet resultSet = maxIdStatement.executeQuery();
            
           int maxClientId = 0;
        
        // Vérifier s'il y a un résultat
        if (resultSet.next()) {
            maxClientId = resultSet.getInt(1);
        }
        
        // Calculer le prochain ID client
        int newClientId = maxClientId + 1;
        
      
            String req = "insert into service values (?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1,newClientId );
            ps.setString(2, o.getNom());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
            System.err.println("Error updating service: " + ex.getMessage());
        }
        return false;
    }
 
    

    public boolean update(Service o) {
        
        //throw new UnsupportedOperationException("Not supported yet.");
    try {
        String req = "update service set nom = ? where id = ?";
        PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        ps.setString(1, o.getNom());
        ps.setInt(2, o.getId());
        if (ps.executeUpdate() == 1)
            return true;
    } catch (SQLException ex) {
        System.err.println("Error updating service: " + ex.getMessage());
    }
    return false;
}
    

    @Override
    public boolean delete(Service o) {
         try {
            String req = "delete from service where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getId());
            if(ps.executeUpdate() == 1)
                return true;
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Service findById(int id) {
        ResultSet rs = null;
         try {
            String req = "select * from service where id  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next())
                return new Service(rs.getInt("id"), rs.getString("nom"));
        } catch (SQLException ex) {
        }
        return null;
    }

    @Override
    public List<Service> findAll() {
         List<Service> services = new ArrayList<>();
         ResultSet rs = null;
         try {
            String req = "select * from service";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
    
            rs = ps.executeQuery();
            while(rs.next())
                services.add(new Service(rs.getInt("id"), rs.getString("nom")));
        } catch (SQLException ex) {
        }
        return services;
    }
    
}
