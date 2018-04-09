package com.coffee.back.service.impl;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.commons.exception.UserAunthenticationException;
import com.coffee.back.controller.impl.UserCtrlImpl;
import com.coffee.back.dao.entity.User;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.coffee.back.dao.impl.WorkerDAOImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author mont
 */
public class UserServiceImplTest {

    private final UserServiceImpl userServiceImpl = new UserServiceImpl();
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final UserCtrlImpl userController = new UserCtrlImpl();

    @Before
    public void configuration() {
        this.userController.setUserService(this.userServiceImpl);
        this.userServiceImpl.setUserDAO(new UserDAOImpl());
        this.userServiceImpl.setWorkerDAO(new WorkerDAOImpl());
    }

    @Test(expected = UserAunthenticationException.class)
    public void iniciarSesionTest() throws UserAunthenticationException{
        UserDTO userVO = new UserDTO();
        userVO.setUserName("ARE@EMP");
        userVO.setPassword("1235");
        userVO.setUserType(UserType.UKNOWN);

        this.userServiceImpl.iniciarSesion(userVO);
                  
    }

    @Test(expected = BadRequest.class)
    public void probarc() throws BadRequest {

        try {
            UserDAOImpl user = new UserDAOImpl();

            User u = user.getUserByNickName("ARE@EM");
        } catch (BadRequest ex) {
            throw ex;
        }

    }
}
