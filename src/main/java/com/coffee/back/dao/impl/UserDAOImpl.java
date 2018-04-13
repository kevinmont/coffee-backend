package com.coffee.back.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.UserDAO;

/**
 * Clase {@code UserDAOImpl} encargada de implementar {@code UserDAO } 
 * la cual establece solicitudes con el servidor
 * de la base de datos de tipo CRUD
 * @see UserDAO
 * @author mont
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

	@Override
	public UserDTO getUserByNickName(String user) throws BadRequestException {
		logger.log(Level.INFO, "DAO: Método getUserByNickName se ha iniciado");
		PreparedStatement statement = null;
		ResultSet userSet = null;
		UserDTO userRecover = null;
		if (!user.isEmpty()) {
			try {
				connection = getConnection();
				statement = connection.prepareStatement("" + "select * from \"users\" where nick_name=?");
				statement.setString(1, user);
				userSet = statement.executeQuery();

				if (userSet.next()) {
					userRecover = new UserDTO();
					userRecover.setWorkerId(userSet.getInt("worker_id"));
					userRecover.setUserName(userSet.getString("nick_name"));
					userRecover.setPassword(userSet.getString("key"));
				}
				userSet.close();
				statement.close();
			} catch (SQLException ex) {
			} finally {
				if (userSet != null) {
					try {
						userSet.close();
						statement.close();
						closeConnection();
					} catch (SQLException ex) {
					}
				}
				if(statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
					}
				}
				closeConnection();
			}
			logger.log(Level.INFO, "DAO: Método getUserByNickName user esta vacio ");
			if(userRecover != null)
				return userRecover;
			throw new BadRequestException("No existe algun usuario "+ user); 
		}
		throw new BadRequestException("parametro user es nulo");
	}

	@Override
	public boolean delete(String nickName) {
		logger.log(Level.INFO, "UserDAO: Inicializando método delete()");
		PreparedStatement preparedStatement = null;
		boolean statusOperation = false;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement("" + "DELETE FROM user where nick_name = ? ");

			preparedStatement.setString(1, nickName);
			logger.log(Level.INFO, "UserDAO: Eliminando usuario " + nickName);
			statusOperation = preparedStatement.executeUpdate() > 0;
			logger.log(Level.INFO, "UserDAO: Usuario " + nickName + " Eliminado");
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null)
				try {
					preparedStatement.close();
				} catch (SQLException e) {
				}
			closeConnection();
		}
		logger.log(Level.INFO, "UserDAO: Finalizando método delete()");
		return statusOperation;
	}

}
