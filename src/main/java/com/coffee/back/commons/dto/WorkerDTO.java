package com.coffee.back.commons.dto;

/**
 * Clase que representa los datos de worker utilizada para el transporte hasta
 * la capa de datos.
 *
 * @author mont
 */
public class WorkerDTO {

    private Integer id;
    private String workerName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String photo;
    private Integer companyId;
    private Integer roleId;
    private UserDTO userDTO;

    /**
     * @return El id de un trabajador
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id El id de un trabajador a ser configurado
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return El nombre de un trabajador
     */
    public String getWorkerName() {
        return workerName;
    }

    /**
     * @param workerName El nombre de un trabajador a ser configurado
     */
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    /**
     * @return String el apellido de un trabajador
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName el apellido de un trabajador
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return La direccion de trabajador
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address La direccion de trabajador a ser configurado
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the userDTO
     */
    public UserDTO getUserDTO() {
        return userDTO;
    }

    /**
     * @param userDTO the userDTO to set
     */
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

}
