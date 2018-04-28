package com.coffee.back.dao.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.UserDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase {@code UserDAOImpl} encargada de implementar {@code UserDAO }
 * la cual establece solicitudes con el servidor de la base de datos de tipo
 * CRUD
 *
 * @see UserDAO
 * @author mont
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public UserDTO getUserByNickName(String user) throws BadRequestException {
        logger.log(Level.INFO, "UserDAO: Método getUserByNickName se ha iniciado");
        PreparedStatement statement = null;
        ResultSet userSet = null;
        UserDTO userRecover = null;
        if (!user.isEmpty()) {
            try {
                connection = getConnection();
                statement = connection.prepareStatement("" + "SELECT * from users where nick_name=?");
                statement.setString(1, user);
                userSet = statement.executeQuery();

                if (userSet.next()) {
                    userRecover = new UserDTO();
                    userRecover.setWorkerId(userSet.getInt("worker_id"));
                    userRecover.setUserName(userSet.getString("nick_name"));
                    userRecover.setPassword(userSet.getString("pass"));
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
            if (userRecover != null) {
                logger.log(Level.INFO, "UserDAO: Método getUserByNickName, user : {0} recuperado",userRecover.getUserName());
                return userRecover;
            }
            throw new BadRequestException("No existe algun usuario " + user);
        }
        throw new BadRequestException("parametro user es nulo");
    }

    @Override
    public boolean create(UserDTO userDTO) {
        logger.log(Level.INFO, "UserDAO: Inicializado create");

        PreparedStatement preparedStatement = null;
        boolean rowsAffected = false;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("insert users "
                    + "(worker_id, nick_name, pass)"
                    + "values (?, ? ,?)");
            preparedStatement.setInt(1, userDTO.getWorkerId());
            preparedStatement.setString(2, userDTO.getUserName());
            preparedStatement.setString(3, userDTO.getPassword());
            logger.log(Level.INFO, "UserDAO: Finalizado create");
            rowsAffected = preparedStatement.executeUpdate() > 0;
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
        logger.log(Level.INFO, "UserDAO: Finalizado create, estado: {0}", rowsAffected);
        return rowsAffected;
    }

    @Override
    public boolean delete(String nickName) {
        logger.log(Level.INFO, "UserDAO: Inicializando método delete()");
        PreparedStatement preparedStatement = null;
        boolean statusOperation = false;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM users where nick_name = ? ");

            preparedStatement.setString(1, nickName);
            logger.log(Level.INFO, "UserDAO: Eliminando usuario {0}", nickName);
            statusOperation = preparedStatement.executeUpdate() > 0;
            logger.log(Level.INFO, "UserDAO: Usuario {0} Eliminado", nickName);
            preparedStatement.close();
        } catch (SQLException e) {
            
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                }
            }
            closeConnection();
        }
        logger.log(Level.INFO, "UserDAO: Finalizando método delete()");
        return statusOperation;
    }
    
    @Override
    public boolean update(UserDTO userDTO){
       logger.log(Level.INFO, "UserDAO: Inicializado update");

        PreparedStatement preparedStatement = null;
        boolean rowsAffected = false;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE users SET "
                    + "nick_name= ?, pass= ? WHERE worker_id= ?");
            preparedStatement.setString(1, userDTO.getUserName());
            preparedStatement.setString(2, userDTO.getPassword());
            preparedStatement.setInt(3, userDTO.getWorkerId());
            logger.log(Level.INFO, "UserDAO: Ejecutando update");
            rowsAffected = preparedStatement.executeUpdate() > 0;
            logger.log(Level.INFO, "UserDAO: Ejecutado update estatus {0}", rowsAffected);
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
        logger.log(Level.INFO, "UserDAO: Finalizado update, usuario: {0}", userDTO.getUserName());
        return rowsAffected;
    }
}
