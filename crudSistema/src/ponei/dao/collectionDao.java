/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponei.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ponei.model.Collection;

/**
 *
 * @author Computador
 */
public class collectionDao {
    public void create(Collection c) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbcollection(name,brand,manufacturer,year,volume)VALUES(?,?,?,?,?)");
            
            stmt.setString(1, c.getNameCollection());
            stmt.setString(2, c.getBrandCollection());
            stmt.setString(3, c.getManufacturerCollection());
            stmt.setInt(4, c.getYearCollection());
            stmt.setInt(5, c.getVolumeCollection());
                       
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }
    }
    

    public List<Collection> list() {
      Connection con = connectionManager.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<Collection> collections = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from tbcollection");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Collection c = new Collection();
                
                c.setIdCollection(rs.getInt("id"));
                c.setNameCollection(rs.getString("name"));
                c.setBrandCollection(rs.getString("brand"));
                c.setManufacturerCollection(rs.getString("manufacturer"));
                c.setYearCollection(rs.getInt("year"));
                c.setVolumeCollection(rs.getInt("volume"));
          
                collections.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.closeConnection(con, stmt, rs);
        }
        return collections;

    }

    public List<Collection> searchForValue(String value, String str) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Collection> collections = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbcollection WHERE " + value + " LIKE ?");
            stmt.setString(1, "%" + str + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Collection c = new Collection();
                
                c.setIdCollection(rs.getInt("id"));
                c.setNameCollection(rs.getString("name"));
                c.setBrandCollection(rs.getString("brand"));
                c.setManufacturerCollection(rs.getString("manufacturer"));
                c.setYearCollection(rs.getInt("year"));
                c.setVolumeCollection(rs.getInt("volume"));
                          
                collections.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.closeConnection(con, stmt, rs);
        }
        return collections;
    }

    public void update(Collection c) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbcollection SET name = ?, brand = ?, manufacturer = ?, year = ?, volume = ? WHERE id = ?");
            
            stmt.setString(1, c.getNameCollection());
            stmt.setString(2, c.getBrandCollection());
            stmt.setString(3, c.getManufacturerCollection());
            stmt.setInt(4, c.getYearCollection());
            stmt.setInt(5, c.getVolumeCollection());
            stmt.setInt(6, c.getIdCollection());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }

    }

    public void delete(Collection c) {

        Connection con = connectionManager.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbcollection WHERE id = ?");
            stmt.setInt(1, c.getIdCollection());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }

    }
}
