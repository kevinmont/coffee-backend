package com.coffee.back.service.impl;

import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequest;
import com.coffee.back.controller.impl.UserCtrlImpl;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.dao.entity.User;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.coffee.back.dao.impl.WorkerDAOImpl;
import org.junit.Test;
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

    @Test
    public void iniciarSesionTest() {
        UserVO userVO = new UserVO();
        userVO.setUser("ARE@EMP");
        userVO.setPassword("12345");
        userVO.setUserType(UserType.UKNOWN);

        this.userController.iniciarSesion(userVO);
    }

    @Test(expected = BadRequest.class)
    public void probarc() throws BadRequest {

        try {
            UserDAOImpl user = new UserDAOImpl();

            User u = user.getUserByNickName("");
        } catch (BadRequest ex) {
            throw ex;
        }

    }
}
