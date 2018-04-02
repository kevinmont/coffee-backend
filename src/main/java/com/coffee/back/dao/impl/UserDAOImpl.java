package com.coffee.back.dao.impl;

import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.UserDAO;
import com.coffee.back.dao.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont
 */
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    private static final Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public User getUserByNickName(String user) throws BadRequest {
        logger.log(Level.INFO, "DAO: Método getUserByNickName se ha iniciado");
        PreparedStatement statement = null;
        ResultSet userSet = null;
        if (!user.isEmpty()) {
            try {

                connection = getConnection();
                statement = connection.prepareStatement(""
                        + "select * from \"users\" where nick_name=?");
                statement.setString(1, user);
                userSet = statement.executeQuery();

                User userRecover = new User();

                userSet.next();
                userRecover.setWorkerId(userSet.getInt("worker_id"));
                userRecover.setNickName(userSet.getString("nick_name"));
                userRecover.setKey(userSet.getString("key"));

                return userRecover;
            } catch (SQLException ex) {
            } finally {
                if (userSet != null && statement != null && connection != null) {
                    try {
                        userSet.close();
                        statement.close();
                        closeConnection();
                    } catch (SQLException ex) {
                    }
                }
            }
        }
        logger.log(Level.INFO, "DAO: Método getUserByNickName user esta vacio ");
        throw new BadRequest("Parametro user es nullo");
    }

}
