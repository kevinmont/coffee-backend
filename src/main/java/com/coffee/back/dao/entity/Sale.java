package com.coffee.back.dao.entity;

import java.util.Date;

/**
 *
 * @author mont
 */
public class Sale {
    
    private Integer saleId;
    private Date dateSale;
    private Double amount;
    private String nickName;
    private Integer ticketId;
    
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
     * @return the dateSale
     */
    public Date getDateSale() {
        return dateSale;
    }

    /**
     * @param dateSale the dateSale to set
     */
    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    /**
     * @return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return the nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return the ticketId
     */
    public Integer getTicketId() {
        return ticketId;
    }

    /**
     * @param ticketId the ticketId to set
     */
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
    
}
