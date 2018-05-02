package com.coffee.back.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.annotation.PostConstruct;

/**
 * Clase abstracta de utilidad encargado de realizar conexion a la base de datos
 * y la configuración.
 *
 * @author mont
 */
public abstract class AbstractDAO {

    private String driverClassName; // Almacenara la clase manejador de JDBC
    private String userName;        // Almacenara el nombre de usuario DBA
    private String password;        // Almacenara el password de usuario DBA
    private String url;             // Almacenara la url del servidor DBMS
    protected Connection connection;    // Recuperador de conexion al DB

    public AbstractDAO() {
        this.driverClassName = "org.postgresql.Driver";
        this.userName = "coffe-ito";
        this.password = "1234";
        this.url = "jdbc:postgresql://localhost?coffe-ito";
    }

    /**
     * Método inicializado despues de que exista una subclase, encargada de
     * Inicializar una instancia de nuestro manejador de JDBC.
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @PostConstruct
    private void initConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName(this.getDriverClassName()).newInstance();
    }

    /**
     * Recupera la conexion a la base de datos si es que existe alguna, de lo
     * contrario lanza un excepción.
     *
     * @return {@code Connection} Conexión al servidor de la base de datos
     * @throws SQLException
     */
    protected Connection getConnection() throws SQLException {
        if (connection != null) {
            return this.connection;
        }
        return this.connection = DriverManager.getConnection(getUrl(), getUserName(), getPassword());
    }

    /**
     * Liberá el recurso establecido a la base de datos y recursos de JDBC en
     * vez de esperar automaticamente.
     */
    protected void closeConnection() {
        try {
            if (connection != null) {
                this.connection.close();
            }
        } catch (SQLException ex) {
        }
    }

    /**
     * Recupera el driver.
     *
     * @return El nombre del driver ClassName
     */
    private String getDriverClassName() {
        return driverClassName;
    }

    /**
     * Configura el driver.
     *
     * @param driverClassName El nombre driver ClassName a ser modificado
     */
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    /**
     * Recupera el nombre de usuario de la base de datos.
     *
     * @return El nombre de usuario
     */
    private String getUserName() {
        return userName;
    }

    /**
     * Configura el nombre de usuario de la base de datos.
     *
     * @param userName El nombre de usuario a ser modificado
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Recupera el password del usuario de la base de datos.
     *
     * @return El password del usuario manejador del DB
     */
    private String getPassword() {
        return password;
    }

    /**
     * Configura el password del usuario de la base de datos.
     *
     * @param password El password del usuario manejador del DB a ser modificado
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Recupera la url del servidor de la base de datos.
     *
     * @return La url del servidor DBMS
     */
    private String getUrl() {
        return url;
    }

    /**
     * Configura la url del servidor de la base de datos.
     *
     * @param url La url del servidor DBMS a ser modificado
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
