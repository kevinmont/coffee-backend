package com.coffee.back.controller.vo;

/**
 * Clase que representa el modelo de un {@code WorkerVO}.
 *
 * @author mont
 */
public class WorkerVO {

    private Integer id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String photo;
    private UserVO userVO;

    /**
     * Recupera el id.
     *
     * @return El id de un trabajador
     */
    public Integer getId() {
        return id;
    }

    /**
     * Configura el id.
     *
     * @param id El Id de un usuario a configurar
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Recupera el nombre.
     *
     * @return {@code String} El nombre de un trabajador.
     */
    public String getName() {
        return name;
    }

    /**
     * Configura el nombre
     *
     * @param name El nombre del trabajador a se modificado
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Recupera el apellido.
     *
     * @return {@code String} El apellido de un trabajador.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Configura el apellido.
     *
     * @param lastName El applido de un trabajador a ser modificado.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Recupera la dirección
     *
     * @return {@code String} La direccion de un trabajador
     */
    public String getAddress() {
        return address;
    }

    /**
     * Configura la direccion.
     *
     * @param address La direccion a ser configurada
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Recupera el número de telefono.
     *
     * @return {@code String} El numero de telefono de un trabajador
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Configura el numero de telefono.
     *
     * @param phoneNumber El numero de telefono de usuario a ser modificado
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Recupera el correo.
     *
     * @return {@code String} El email de un trabajador
     */
    public String getEmail() {
        return email;
    }

    /**
     * Configura el correo.
     *
     * @param email El email a ser configurado
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Recupera la foto.
     *
     * @return {@code String} La direccion absoluta de la foto
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Configura la foto.
     *
     * @param photo La direccion de la foto a ser cofigurada.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Configura el usuario.
     *
     * @return {@code UserVO} El usuario registrado para el trabajador
     */
    public UserVO getUserVO() {
        return userVO;
    }

    /**
     * Recupera el usuario.
     *
     * @param userVO La cuenta de usuario del trabajador.
     */
    public void setUserVO(UserVO userVO) {
        this.userVO = userVO;
    }

}
