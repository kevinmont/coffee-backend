package com.coffee.back.service.impl;

import com.coffee.back.ConfigureUserDI;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.commons.exception.NotFoundException;
import com.coffee.back.commons.exception.UserAuthenticationException;
import com.coffee.back.controller.UserCtrl;
import com.coffee.back.controller.impl.UserCtrlImpl;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.controller.vo.WorkerVO;
import com.coffee.back.dao.impl.UserDAOImpl;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author mont
 */
public class UserServiceImplTest {

    private UserCtrl userController;

    @Before
    public void configuration() {
        Injector injector = Guice.createInjector(new ConfigureUserDI());
        this.userController= injector.getInstance(UserCtrlImpl.class);
    }

    @Test
    public void iniciarSesionTest() throws UserAuthenticationException {
        UserVO userVO = new UserVO();
        userVO.setUserName("ARE@EMP");
        userVO.setPassword("1234");
        userVO.setUserType(UserType.UKNOWN);

        UserVO user= this.userController.iniciarSesion(userVO);
        assertNotNull(user);
        assertEquals(UserType.CAJERO, user.getUserType());
        assertSame(UserType.CAJERO, user.getUserType());
    }

    @Test(expected = BadRequestException.class)
    public void probarc() throws BadRequestException {
        try {
            UserDAOImpl user = new UserDAOImpl();
            user.getUserByNickName("ARE@EM");
        } catch (BadRequestException ex) {
            throw ex;
        }

    }
    
    @Test
    public void modificarUsuario(){
        WorkerVO worker = new WorkerVO();
        worker.setId(1);
        worker.setName("PENELOPE");
        worker.setLastName("LOPEZ");
        worker.setAddress("ORIZABA COL ZAPATA #223");
        worker.setPhoneNumber("2721342343");
        worker.setEmail("NULL");
        worker.setPhoto("NULL");
        UserVO user = new UserVO();
        user.setUserName("PENELOPE");
        user.setUserType(UserType.CAJERO);
        user.setPassword("1234");
        worker.setUserVO(user);
        String status = this.userController.modificarUsuario(worker);
        System.out.println(status);
        assertNotNull(status);
    }

    @Test
    public void getUser(){
        String name= "PEDRO";
        try {
            WorkerVO worker = this.userController.buscarUsuario(name);
            assertNotNull(worker);
            assertEquals("PEDRO", worker.getName());
        } catch (NotFoundException ex) {
        }
        
    }
    
    @Test
    public void insertUser(){
        WorkerVO worker = new WorkerVO();
        worker.setName("PENELOPE");
        worker.setLastName("LOPEZ");
        worker.setAddress("ORIZABA COL ZAPATA #223");
        worker.setPhoneNumber("2721342343");
        worker.setEmail("penelope10@gmail.com");
        worker.setPhoto("NULL");
        UserVO user = new UserVO();
        user.setUserName("gusanito");
        user.setUserType(UserType.CAJERO);
        user.setPassword("1234");
        worker.setUserVO(user);
        String statusOperation=this.userController.altaUsuario(worker);
        System.out.println(statusOperation);
        assertNotNull(user);
    }
    
    @Test
    public void readAll(){
        List<WorkerVO> workerVOs= this.userController.buscarUsuarios();
        workerVOs.forEach((t)->{
            System.out.println(t.getEmail());
        });
        assertNotNull(workerVOs);
    }
}
