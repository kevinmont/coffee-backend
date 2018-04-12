package com.coffee.back.commons.dto;

/**
 * Clase que representa los datos de categoria para la transferencia
 * @author mont
 */
public class CategoryDTO {

    private Integer categoryId;
    private String categoryName;
    
    /**
     * @return El id de una categoria
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId El id de una categoria a modificar
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return El nombre de la categoria
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName El nombre de la categoria a modificar
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
   
}
