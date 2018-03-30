package com.coffee.back.dao.entity;

/**
 *
 * @author mont
 */
public class Company {

    private Integer companyId;
    private String nameCompany;
    private String address;
    private String legend;
    private String icon;
    
    /**
     * @return the companyId
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId the companyId to set
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the nameCompany
     */
    public String getNameCompany() {
        return nameCompany;
    }

    /**
     * @param nameCompany the nameCompany to set
     */
    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the legend
     */
    public String getLegend() {
        return legend;
    }

    /**
     * @param legend the legend to set
     */
    public void setLegend(String legend) {
        this.legend = legend;
    }

    /**
     * @return the icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
