package com.coffee.back.controller.vo;

import java.util.List;

/**
 * Clase que representa el modelo de una venta
 *
 * @author mont
 */
public class SaleVO {

    private String cashierNickName;   // Almacena el id de un trabajador
    private Integer saleId;     // Almacena el id de una venta
    private String dateSale;      // Almacena la fecha de venta
    private Double totalSale;      // Almacena la cantidad total de la venta
    private List<SaleProduct> saleProduct;  // Almacena el modelo de los productos vendidos

    public SaleVO() {

    }

    /**
     * Recupera el nombre del cajero de la venta
     *
     * @return El NickName del trabajador
     */
    public String getCashierNickName() {
        return cashierNickName;
    }

    /**
     * Configura el NickName del cajero quien realizo la venta
     *
     * @param cashierNickName El NickName del trabajador a modificar
     */
    public void setCashierNickName(String cashierNickName) {
        this.cashierNickName = cashierNickName;
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
    public String getDateSale() {
        return dateSale;
    }

    /**
     * Configura la fecha de la venta.
     *
     * @param dateSale La fecha de venta a modificar
     */
    public void setDateSale(String dateSale) {
        this.dateSale = dateSale;
    }

    /**
     * Recupera el total de la venta
     *
     * @return La cantidad de la venta
     */
    public Double getTotalSale() {
        return totalSale;
    }

    /**
     * Configura el total de la venta.
     *
     * @param totalSale La cantidad de la venta a modificar
     */
    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
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

        private Integer quantityProduct;
        private String productName;
        private Integer productId;
        private Double neto;

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
         * Recupera el nombre del producto vendido.
         *
         * @return El nombre del producto
         */
        public String getProductName() {
            return productName;
        }

        /**
         * Configura el nombre del producto vendido.
         *
         * @param productName El nombre del producto a modificar
         */
        public void setProductName(String productName) {
            this.productName = productName;
        }

        /**
         * Retorna el id del producto
         *
         * @return El id del producto
         */
        public Integer getProductId() {
            return productId;
        }

        /**
         * Configura el id del producto.
         *
         * @param productId El id del producto a configurar
         */
        public void setProductId(Integer productId) {
            this.productId = productId;
        }

        /**
         * Retorna el neto por la venta del producto.
         *
         * @return El neto por la venta de este producto es calculado mediante
         * el numero de productos y el precio del producto
         */
        public Double getNeto() {
            return neto;
        }

        /**
         * Configura el neto por la venta del producto.
         *
         * @param neto the neto to set
         */
        public void setNeto(Double neto) {
            this.neto = neto;
        }

    }

}
