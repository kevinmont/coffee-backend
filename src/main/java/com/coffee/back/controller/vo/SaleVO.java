package com.coffee.back.controller.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa el modelo de una venta
 * @author mont
 */
public class SaleVO {

    private Integer workerId;   // Almacena el id de un trabajador
    private Integer saleId;     // Almacena el id de una venta
    private Date dateSale;      // Almacena la fecha de venta
    private Double amount;      // Almacena la cantidad total de la venta
    private List<SaleProduct> saleProduct;  // Almacena el modelo de los productos vendidos

    public SaleVO() {
        
    }
    
    /**
     * @return El id del trabajador
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * @param workerId El id del trabajador a modificar
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    /**
     * @return El id de una venta
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * @param saleId El id de una venta a modificar
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     * @return La fecha de venta
     */
    public Date getDateSale() {
        return dateSale;
    }

    /**
     * @param dateSale La fecha de venta a modificar
     */
    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    /**
     * @return La cantidad de la venta
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount La cantidad de la venta a modificar
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return La lista de productos vendidos
     */
    public List<SaleProduct> getSaleProduct() {
        return saleProduct;
    }

    /**
     * @param saleProduct La lista de productos vendidos a modificar
     */
    public void setSaleProduct(List<SaleProduct> saleProduct) {
        this.saleProduct = saleProduct;
    }

    public class SaleProduct {

        private Integer productId;
        private Integer quantityProduct;
        private Double neto;
        
        /**
         * @return El id de un producto 
         */
        public Integer getProductId() {
            return productId;
        }

        /**
         * @param productId El id de un producto a modificar
         */
        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        /**
         * @return La cantidad total vendidad del producto
         */
        public Integer getQuantityProduct() {
            return quantityProduct;
        }

        /**
         * @param quantityProduct La cantidad total vendida del producto a modificar
         */
        public void setQuantityProduct(Integer quantityProduct) {
            this.quantityProduct = quantityProduct;
        }

        /**
         * @return El neto del producto
         */
        public Double getNeto() {
            return neto;
        }

        /**
         * @param neto El neto del producto a modificar
         */
        public void setNeto(Double neto) {
            this.neto = neto;
        }
        
    }

}
