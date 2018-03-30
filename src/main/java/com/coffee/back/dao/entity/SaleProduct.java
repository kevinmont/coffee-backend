package com.coffee.back.dao.entity;

/**
 *
 * @author mont
 */
public class SaleProduct {

    private Integer saleId;
    private Integer productId;
    private Integer quantityProduct;
    private Integer neto;
    
    /**
     * @return the saleId
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * @param saleId the saleId to set
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

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
     * @return the quantityProduct
     */
    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    /**
     * @param quantityProduct the quantityProduct to set
     */
    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    /**
     * @return the neto
     */
    public Integer getNeto() {
        return neto;
    }

    /**
     * @param neto the neto to set
     */
    public void setNeto(Integer neto) {
        this.neto = neto;
    }
    
}
