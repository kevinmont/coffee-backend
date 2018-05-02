package com.coffee.back.dao;

import com.coffee.back.commons.dto.UserDTO;
import com.coffee.back.commons.exception.BadRequestException;
import com.coffee.back.commons.exception.NotFoundException;

/**
 * Interfaz {@code UserDAO} encargada de establecer solicitudes con el servidor
 * de la base de datos de tipo CRUD
 *
 * @author mont
 */
public interface UserDAO {

    /**
     * Consigue un usuario registrado en el sistema
     *
     * @param user identificador unico del usuario a ser buscado
     * @return {@Code User} que se encuentra registrado en el sistema
     * @throws BadRequestException si el usuario no existe o campos incompletos
     */
    UserDTO getUserByNickName(String user) throws BadRequestException;

    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param workerDTO Identifica el usuario a moficar
     * @return {@code true} si el usuario fue creado exitosamente de lo
     * contrario un {@code false}.
     */
    boolean create(UserDTO workerDTO);

    /**
     * Elimina un usuario en el sistema;
     *
     * @param nickName identifica el nombre del usuario a eliminar
     * @return {@code true} si el usuario fue borrado exitosamente de lo
     * contrario un {@code false}.
     */
    boolean delete(String nickName);

    /**
     * Actualiza un usuario del sistema.
     *
     * @param userDTO Usuario con las modificaciones
     * @return {@code true} si la actualizacion se llevo a cabo con exito de lo
     * contrario {@code false}.
     */
    boolean update(UserDTO userDTO);

    /**
     * Recupera un usuario.
     *
     * @param id Identificador para un usuario.
     * @return {@code UserDTO} Modelo de un usuario.
     * @throws com.coffee.back.commons.exception.NotFoundException Se lanza
     * cuando no es encontrado el role.
     */
    UserDTO getUserById(Integer id) throws NotFoundException;

}
