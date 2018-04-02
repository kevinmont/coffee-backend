package com.coffee.back.dao.impl;

import com.coffee.back.commons.enums.UserType;
import com.coffee.back.dao.AbstractDAO;
import com.coffee.back.dao.WorkerDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mont
 */
public class WorkerDAOImpl extends AbstractDAO implements WorkerDAO {

    @Override
    public UserType getRoleNameByWorkerId(Integer workerId) {

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
            return roleName;
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
        return roleName;
    }

}
