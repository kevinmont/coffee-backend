package com.coffee.back.dao.entity;

/**
 *
 * @author mont
 */
public class Product {
    
    private Integer productId;
    private String productName;
    private Double priceTag;
    private Integer quantity;
    private Boolean isFood;
    private String image;
    private Integer categoryId;

    /**
     * @return the productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the priceTag
     */
    public Double getPriceTag() {
        return priceTag;
    }

    /**
     * @param priceTag the priceTag to set
     */
    public void setPriceTag(Double priceTag) {
        this.priceTag = priceTag;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the isFood
     */
    public Boolean getIsFood() {
        return isFood;
    }

    /**
     * @param isFood the isFood to set
     */
    public void setIsFood(Boolean isFood) {
        this.isFood = isFood;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the categoryId
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    } 
}
