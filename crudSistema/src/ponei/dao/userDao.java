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
import ponei.model.User;

/**
 *
 * @author Computador
 */
public class userDao {
    
    public void create(User u) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tbusers(name,login,pass)VALUES(?,?,?)");
            
            stmt.setString(1, u.getNameUser());
            stmt.setString(2, u.getLoginUser());
            stmt.setString(3, u.getPassUser());
                       
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }
    }
 
    public boolean checkLogin(String login, String pass) {

        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;

        try {

            stmt = con.prepareStatement("SELECT * FROM tbusers WHERE login = ? and pass = ?");
            stmt.setString(1, login);
            stmt.setString(2, pass);

            rs = stmt.executeQuery();

            if (rs.next()) {

                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.closeConnection(con, stmt, rs);
        }

        return check;

    }
    

    public List<User> list() {
      Connection con = connectionManager.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      List<User> users = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from tbusers");
            rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                
                u.setIdUser(rs.getInt("id"));
                u.setNameUser(rs.getString("name"));
                u.setLoginUser(rs.getString("login"));
                u.setPassUser(rs.getString("pass"));
                
                
                
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.closeConnection(con, stmt, rs);
        }
        return users;

    }

    public List<User> searchForValue(String value, String str) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusers WHERE " + value + " LIKE ?");
            stmt.setString(1, "%" + str + "%");
            rs = stmt.executeQuery();
            while (rs.next()) {
                User u = new User();
                
                u.setIdUser(rs.getInt("id"));
                u.setNameUser(rs.getString("name"));
                u.setLoginUser(rs.getString("login"));
                u.setPassUser(rs.getString("pass"));
                
                
                
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(userDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            connectionManager.closeConnection(con, stmt, rs);
        }
        return users;
    }

    public void update(User u) {
        Connection con = connectionManager.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tbusers SET name = ?, login = ?, pass = ? WHERE id = ?");
            
            stmt.setString(1, u.getNameUser());
            stmt.setString(2, u.getLoginUser());
            stmt.setString(3, u.getPassUser());
            stmt.setInt(4, u.getIdUser());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }

    }

    public void delete(User u) {

        Connection con = connectionManager.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbusers WHERE id = ?");
            stmt.setInt(1, u.getIdUser());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            connectionManager.closeConnection(con, stmt);
        }

    }
}
