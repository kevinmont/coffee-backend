package com.coffee.back.controller.vo;

/**
 * Clase que representa el modelo de un producto
 *
 * @author mont
 */
public class ProductVO {

    private Integer id;         //Almacenara el id de un producto
    private String productName; //Almacenara el nombre de un producto
    private Double priceTag;    //Almacenara el precio de un producto
    private Short quantity;     //Almacenara la cantidad de dicho producto
    private String image;       //Almacenara la imagen del producto
    private String categoryName; //Almacenara la categoria perteneciente al producto

    /**
     * Recupera el id
     *
     * @return {@code Integer} El id de un producto
     */
    public Integer getId() {
        return id;
    }

    /**
     * Configura el id
     *
     * @param id El id de un producto a ser configurado
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Recupera el nombre
     *
     * @return el nombre del producto
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Configura el nombre
     *
     * @param productName El nombre del producto a modificar
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Recupera el precio
     *
     * @return El precion de un producto
     */
    public Double getPriceTag() {
        return priceTag;
    }

    /**
     * Configura el precio
     *
     * @param priceTag El precio de un producto a modificar
     */
    public void setPriceTag(Double priceTag) {
        this.priceTag = priceTag;
    }

    /**
     * Recupera la cantidad existente
     *
     * @return la cantidad existente del producto
     */
    public Short getQuantity() {
        return quantity;
    }

    /**
     * Configura la cantidad existente
     *
     * @param quantity La cantidad de un producto a modificar
     */
    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    /**
     * Recupera el la ruta absoluta a la imagen
     *
     * @return La imagen del producto
     */
    public String getImage() {
        return image;
    }

    /**
     * Configura la ruta absoluta a la imagen
     *
     * @param image La imagen del producto a modificar
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Recupera el nombre de la categoria
     *
     * @return La id de categoria perteneciente del producto
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Configura el nombre de la categoria
     *
     * @param categoryName La id de categoria perteneciente del producot a
     * modificar
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
