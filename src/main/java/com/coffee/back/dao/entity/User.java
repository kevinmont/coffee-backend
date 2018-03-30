package com.coffee.back.dao.entity;

/**
 *
 * @author mont
 */
public class User {

    private String nickName;
    private String key;
    private Integer workerId;
    
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
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the workerId
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * @param workerId the workerId to set
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }
    
}
