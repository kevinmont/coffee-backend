package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.WorkerDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code WorkerDAOImpl} encargada de implementar {@code WorkerDAO }
 * la cual establece solicitudes con el servidor de la base de datos de tipo
 * CRUD
 *
 * @see WorkerDAO
 * @author mont
 */
public class WorkerDAOImpl extends AbstractDAO implements WorkerDAO {
    
    private static final Logger logger = Logger.getLogger(WorkerDAOImpl.class.getName());

    @Override
    public UserType getRoleNameByWorkerId(Integer workerId) {
        logger.log(Level.INFO, "WorkerDAOImpl : Iniciando método getRoleNameByWorkerId()");
        UserType roleName = UserType.UKNOWN;
        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(""
                    + "SELECT role_name FROM worker JOIN \"role\" USING(role_id) where worker_id = ? limit 1");
            statement.setInt(1, workerId);
            result = statement.executeQuery();
            result.next();
            switch (result.getString("role_name")) {
                case "ADMINISTRADOR":
                    roleName = UserType.ADMINISTRADOR;
                    break;
                case "CAJERO":
                    roleName = UserType.CAJERO;
                    break;
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (result != null && statement != null) {
                try {
                    result.close();
                    statement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "WorkerDAOImpl : Finalizando método getRoleNameByWorkerId()");
        return roleName;
    }

    @Override
    public boolean create(WorkerDTO workerDTO) {
        logger.log(Level.INFO, "WorkerDAOImpl: Inicializado create");

        PreparedStatement preparedStatement = null;
        boolean rowsAffected = false;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("INSERT into worker "
                    + "(worker_name, last_name, address, phone_number, email, photo, company_id, role_id)"
                    + "values (?, ?, ?, ?, ?, ?, ?, ? )");
            
            preparedStatement.setString(1, workerDTO.getWorkerName());
            preparedStatement.setString(2, workerDTO.getLastName());
            preparedStatement.setString(3, workerDTO.getAddress());
            preparedStatement.setString(4, workerDTO.getPhoneNumber());
            preparedStatement.setString(5, workerDTO.getEmail());
            preparedStatement.setString(5, workerDTO.getPhoto());
            preparedStatement.setInt(7, 1);
            preparedStatement.setInt(8, 2);
            logger.log(Level.INFO, "WorkerDAOImpl: Ejecutando insert");
            rowsAffected = preparedStatement.executeUpdate() > 0;
            logger.log(Level.INFO, "WorkerDAOImpl: Finalizado insert");
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    //Omitido excepción
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "WorkerDAOImpl: Finalizado create, estado: {0}", rowsAffected);
        return rowsAffected;
    }
}
