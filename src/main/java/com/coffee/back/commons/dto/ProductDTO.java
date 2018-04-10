package com.coffee.back.commons.dto;

/**
 * Clase que representa los datos de producto para la transferencia
 * @author mont
 */
public class ProductDTO {

    private Integer productId;  //Almacenara el id de un producto
    private String productName; //Almacenara el nombre de un producto
    private Double priceTag;    //Almacenara el precio de un producto
    private Short quantity;     //Almacenara la cantidad de dicho producto
    private Boolean isFood;     //Almacenara si el productos es comida o no
    private String image;       //Almacenara la imagen del producto
    private Integer categoryId; //Almacenara la categoria perteneciente al producto
    
    /**
     * @return el id de un producto
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId el id de un producto a modificar
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return el nombre del producto
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName El nombre del producto a modificar
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return El precion de un producto
     */
    public Double getPriceTag() {
        return priceTag;
    }

    /**
     * @param priceTag El precio de un producto a modificar
     */
    public void setPriceTag(Double priceTag) {
        this.priceTag = priceTag;
    }

    /**
     * @return la cantidad existente del producto
     */
    public Short getQuantity() {
        return quantity;
    }

    /**
     * @param quantity La cantidad de un producto a modificar
     */
    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    /**
     * @return El producto si es comida
     */
    public Boolean getIsFood() {
        return isFood;
    }

    /**
     * @param isFood El producto si es comida a modificar
     */
    public void setIsFood(Boolean isFood) {
        this.isFood = isFood;
    }

    /**
     * @return La imagen del producto
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image La imagen del producto a modificar
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return La id de categoria perteneciente del producto
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId La id de categoria perteneciente del producot a modificar
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
            
}
