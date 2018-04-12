package com.coffee.back.controller.vo;

/**
 * Clase que representa el modelo de un producto
 * @author mont
 */
public class ProductVO {

    private String productName; //Almacenara el nombre de un producto
    private Double priceTag;    //Almacenara el precio de un producto
    private Short quantity;     //Almacenara la cantidad de dicho producto
    private String image;       //Almacenara la imagen del producto
    private String categoryName; //Almacenara la categoria perteneciente al producto
    
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
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName La id de categoria perteneciente del producot a modificar
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
}
