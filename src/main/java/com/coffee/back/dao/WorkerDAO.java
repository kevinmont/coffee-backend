package com.coffee.back.dao;

import com.coffee.back.commons.dto.WorkerDTO;
import com.coffee.back.commons.enums.UserType;
import com.coffee.back.commons.exception.NotFoundException;
import java.util.List;

/**
 * Interfaz {@code WorkerDAO} encargada de establecer solicitudes con el
 * servidor de la base de datos de tipo CRUD
 *
 * @author mont
 */
public interface WorkerDAO {

    /**
     * Recupera el role de un usuario
     *
     * @param workerId identificador perteneciente a un usuario
     * @return {@code UserType} que indentifica el rol del usuario
     */
    UserType getRoleNameByWorkerId(Integer workerId);

    /**
     * Crea un nuevo usuario que pertenecera al sistema
     *
     * @param workerDTO
     * @return {@code true} Si el usuario se ha creado exitosamente de lo
     * contrario {@code false}
     */
    boolean create(WorkerDTO workerDTO);

    /**
     * Actualiza un usuario existente.
     *
     * @param workerDTO Identifica a un usuario perteneciente al sistema.
     * @return {@code true} si el {@code workerDTO} se ha actualizado
     * exitosament de lo contrario un {@code false}
     */
    boolean update(WorkerDTO workerDTO);

    /**
     * Recupera a un usuario.
     *
     * @param name Identifica el nombre de un usuario.
     * @return {@code WorkerDTO} el modelo para un usuario.
     * @throws com.coffee.back.commons.exception.NotFoundException Se lanza
     * cuando el usuario no fue encontrado
     */
    WorkerDTO getUserByName(String name) throws NotFoundException;

    /**
     *
     * @param workerID Identificador de un trabajador
     * @return {@code true} Si el trabajador ha sido eliminado exitosamente de
     * lo contrario {@code false}
     */
    public boolean delete(Integer workerID);

    /**
     * Recupera a un usuario por su correo
     *
     * @param email Email perteneciente al usuario
     * @return WorkerDTO Recupera un trabajador
     * @throws com.coffee.back.commons.exception.NotFoundException Se lanza si
     * el trabajador con el email indicado no existe
     */
    public WorkerDTO getUserByEmail(String email) throws NotFoundException;

    /**
     * Recupera todos los trabajadores registrados
     *
     * @return {@code List<WorkerDTO>} Un array con todos los usuarios
     * registrados
     */
    public List<WorkerDTO> readAll();

}
