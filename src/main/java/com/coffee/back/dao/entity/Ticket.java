package com.coffee.back.dao.entity;

/**
 *
 * @author mont
 */
public class Ticket {

    private Integer ticketId;
    private Integer numTicketDay;
    private Integer saleId;
    
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

    /**
     * @return the numTicketDay
     */
    public Integer getNumTicketDay() {
        return numTicketDay;
    }

    /**
     * @param numTicketDay the numTicketDay to set
     */
    public void setNumTicketDay(Integer numTicketDay) {
        this.numTicketDay = numTicketDay;
    }

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
    
}
