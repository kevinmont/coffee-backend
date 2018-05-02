package com.coffee.back.controller.vo;

import java.util.Date;
import java.util.List;

/**
 * Clase que representa el modelo de una venta
 *
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
     * Recupera el id del trabajador
     *
     * @return El id del trabajador
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * Configura el id del trabajador
     *
     * @param workerId El id del trabajador a modificar
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    /**
     * Recupera el id de una venta
     *
     * @return El id de una venta
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * Configura el id de una venta
     *
     * @param saleId El id de una venta a modificar
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     * Recupera la fecha de la venta
     *
     * @return La fecha de venta
     */
    public Date getDateSale() {
        return dateSale;
    }

    /**
     * Configura la fecha de la venta.
     *
     * @param dateSale La fecha de venta a modificar
     */
    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    /**
     * Recupera el total de la venta
     *
     * @return La cantidad de la venta
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Configura el total de la venta.
     *
     * @param amount La cantidad de la venta a modificar
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * Recupera los productos vendidos para esta venta
     *
     * @return La lista de productos vendidos
     */
    public List<SaleProduct> getSaleProduct() {
        return saleProduct;
    }

    /**
     * Configura los productos vendidos en esta venta.
     *
     * @param saleProduct La lista de productos vendidos a modificar
     */
    public void setSaleProduct(List<SaleProduct> saleProduct) {
        this.saleProduct = saleProduct;
    }

    /**
     * Clase hija que representa los productos para el la venta.
     */
    public class SaleProduct {

        private Integer productId;
        private Integer quantityProduct;
        private Double neto;

        /**
         * Recupera el id
         *
         * @return El id de un producto
         */
        public Integer getProductId() {
            return productId;
        }

        /**
         * Configura el id
         *
         * @param productId El id de un producto a modificar
         */
        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        /**
         * Recupera la cantidad de productos de este tipo
         *
         * @return La cantidad total vendidad del producto
         */
        public Integer getQuantityProduct() {
            return quantityProduct;
        }

        /**
         * Configura la cantidad de productos de este tipo.
         *
         * @param quantityProduct La cantidad total vendida del producto a
         * modificar
         */
        public void setQuantityProduct(Integer quantityProduct) {
            this.quantityProduct = quantityProduct;
        }

        /**
         * Recupera el neto de los productos vendidos.
         *
         * @return El neto del producto
         */
        public Double getNeto() {
            return neto;
        }

        /**
         * Configura el neto de los productos vendidos.
         *
         * @param neto El neto del producto a modificar
         */
        public void setNeto(Double neto) {
            this.neto = neto;
        }

    }

}
