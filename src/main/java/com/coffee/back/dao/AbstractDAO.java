/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coffee.back.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author mont
 */
public abstract class AbstractDAO {
   
    private String driverClassName;
    private String userName;
    private String password;
    private String url;
    protected Connection connection;
    
    public AbstractDAO(){
        this.driverClassName="org.postgresql.Driver";
        this.userName="coffe-ito";
        this.password="1234";
        this.url="jdbc:postgres//localhost?coffe-ito";
    }
    
    @PostConstruct
    private void initConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        Class.forName(this.url).newInstance();
    }
    
    protected  Connection getConnection() throws SQLException{
        return DriverManager.getConnection(getUrl(), getUserName(), getPassword());
    }
    
    protected void closeConnection() {        
        try {
            if(connection != null)
                this.connection.close();
        } catch (SQLException ex) {  }
    }

    /**
     * @return the driverClassName
     */
    private String getDriverClassName() {
        return driverClassName;
    }

    /**
     * @param driverClassName the driverClassName to set
     */
    
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * @return the userName
     */
    private String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    private String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the url
     */
    private String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
