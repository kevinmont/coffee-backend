package com.coffee.back.controller;

import com.coffee.back.commons.exception.NotFoundException;
import com.coffee.back.controller.vo.UserVO;
import com.coffee.back.controller.vo.WorkerVO;

/**
 * La interfaz {@code UserCtrl} es encargada de recibir las peticiones lanzadas
 * por el usuario desde la vista, se encarga de manejar y ejecutar los servicos
 * de un Usuario
 *
 * @author mont
 */
public interface UserCtrl {

    /**
     * Realiza el inicio de sesión de un usuario.
     *
     * @param userVO estado del objeto que intenta iniciar sesion
     * @return UserVO el modelo recuperado de un usuario
     */
    UserVO iniciarSesion(UserVO userVO);

    /**
     * Indica el cierre de sesión de un usuario.
     *
     * @param userVO estado del objeto actual en el sistema.
     * @return retorna {@code true} si el usuario es administrador de lo
     * contrario {@code false}
     */
    boolean cerrarSesion(UserVO userVO);

    /**
     * Elimina a un usuario almacenado en el sistema
     *
     * @param nickName Identifica a un usuario capaz de iniciar sesion
     * @return Retorna una cadena indicando el estado de la operacion
     */
    String bajaUsuario(String nickName);

    /**
     * Agrega un nuevo usuario al sistema
     *
     * @param workerVO Indica el nuevo usuario a crear
     * @return {@code String} Indicando el estado de la operacion
     */
    String altaUsuario(WorkerVO workerVO);

    /**
     * Modifica a un usuario existente en el sistema
     *
     * @param workerVO Indica el usuario perteneciente al sistema que será
     * modificado
     * @return {@code String} Indicando el estado de la operacion
     */
    String modificarUsuario(WorkerVO workerVO);

    /**
     * Busca un usuario dentro del sistema
     *
     * @param name Representa el nombre del usuario a buscar
     * @return {@code UserVO} representa al usuario encontrado.
     * @throws com.coffee.back.commons.exception.NotFoundException Es lanzado
     * cuando no se encuentra a un usuario con el nombre pasado como argumento.
     */
    WorkerVO buscarUsuario(String name) throws NotFoundException;
}
