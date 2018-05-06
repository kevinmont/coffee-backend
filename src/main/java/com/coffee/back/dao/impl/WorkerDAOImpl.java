package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.NotFoundException;
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
            preparedStatement = connection.prepareStatement("INSERT into worker"
                    + " (worker_name, last_name, address, phone_number, email, photo, company_id, role_id)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ? )");

            preparedStatement.setString(1, workerDTO.getWorkerName());
            preparedStatement.setString(2, workerDTO.getLastName());
            preparedStatement.setString(3, workerDTO.getAddress());
            preparedStatement.setString(4, workerDTO.getPhoneNumber());
            preparedStatement.setString(5, workerDTO.getEmail());
            preparedStatement.setString(6, workerDTO.getPhoto());
            preparedStatement.setInt(7, 1);
            preparedStatement.setInt(8, 2);
            logger.log(Level.INFO, "WorkerDAOImpl: Ejecutando insert");
            rowsAffected = preparedStatement.executeUpdate() > 0;
            logger.log(Level.INFO, "WorkerDAOImpl: Finalizado insert");
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

    @Override
    public boolean update(WorkerDTO workerDTO) {
        logger.log(Level.INFO, "WorkerDAOImpl#update Iniciando {0}", workerDTO.getWorkerName());
        boolean rowsAffected = false;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE worker SET" // estructura sql para actualizacion.
                    + " worker_name = ?,"
                    + " last_name = ?, address = ?,"
                    + " phone_number = ?, email = ?,"
                    + " photo= ?, company_id=?, role_id= ?"
                    + " WHERE worker_id = ?"); // el id de un trabajador debe ser unico

            preparedStatement.setString(1, workerDTO.getWorkerName());
            preparedStatement.setString(2, workerDTO.getLastName());
            preparedStatement.setString(3, workerDTO.getAddress());
            preparedStatement.setString(4, workerDTO.getPhoneNumber());
            preparedStatement.setString(5, workerDTO.getEmail());
            preparedStatement.setString(6, workerDTO.getPhoto());
            preparedStatement.setInt(7, 1);
            preparedStatement.setInt(8, 2);

            preparedStatement.setInt(9, workerDTO.getId());

            logger.log(Level.INFO, "WorkerDAOImpl#update Iniciando update");
            rowsAffected = preparedStatement.executeUpdate() > 0;
            logger.log(Level.INFO, "WorkerDAOImpl#update Finalizando update estatus {0}", rowsAffected);
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "WorkerDAOImpl#update Finalizando {0}", workerDTO.getWorkerName());
        return rowsAffected;
    }

    @Override
    public WorkerDTO getUserByName(String name) throws NotFoundException {
        logger.log(Level.INFO, "WorkerDAO: Método getUserByName se ha iniciado");
        PreparedStatement statement = null;
        ResultSet userSet = null;
        WorkerDTO worker = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT * FROM worker"
                    + " WHERE worker_name like ? LIMIT 1");
            statement.setString(1, "%" + name + "%");
            userSet = statement.executeQuery();
            if (userSet.next()) {
                worker = new WorkerDTO();
                worker.setId(userSet.getInt("worker_id"));
                worker.setWorkerName(userSet.getString("worker_name"));
                worker.setLastName(userSet.getString("last_name"));
                worker.setAddress(userSet.getString("address"));
                worker.setPhoneNumber(userSet.getString("phone_number"));
                worker.setEmail(userSet.getString("email"));
                worker.setPhoto(userSet.getString("photo"));
                worker.setCompanyId(userSet.getInt("company_id"));
                worker.setRoleId(userSet.getInt("role_id"));
            }
            userSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
        } finally {
            if (userSet != null) {
                try {
                    userSet.close();
                } catch (SQLException ex) {
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
            closeConnection();
        }
        if (worker != null) {
            logger.log(Level.INFO, "UserDAO: Método getUserByName, user : {0} recuperado", name);
            return worker;
        }
        throw new NotFoundException();
    }
}
