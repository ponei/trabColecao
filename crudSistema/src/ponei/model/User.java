/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ponei.model;

/**
 *
 * @author Computador
 */
public class User {

    private int idUser;
    private String nameUser;
    private String loginUser;
    private String passUser;

//Construtor padrão

    public User(int idUser, String nameUser, String loginUser, String passUser) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.loginUser = loginUser;
        this.passUser = passUser;
    }

    public User() {
    }
    
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }
}
