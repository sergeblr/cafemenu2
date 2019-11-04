/**package com.cafemenu.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "item_in_order")
public class ItemInOrder {

    @EmbeddedId
    private IioKey iioKey;

    @Column(nullable = false)
    private Integer iioOrderId;

    @Column(nullable = false)
    private Integer iioItemId;

    @Column(nullable = false)
    private String iioItemName;

    @Column(nullable = false)
    private BigDecimal iioItemPrice;

    @Column(nullable = false)
    private Integer iioItemCount;


    
    public IioKey getIioKey() {
        return iioKey;
    }

    public void setIioKey(IioKey iioKey) {
        this.iioKey = iioKey;
    }

    public Integer getIioOrderId() {
        return iioOrderId;
    }

    public void setIioOrderId(Integer iioOrderId) {
        this.iioOrderId = iioOrderId;
    }

    public Integer getIioItemId() {
        return iioItemId;
    }

    public void setIioItemId(Integer iioItemId) {
        this.iioItemId = iioItemId;
    }

    public String getIioItemName() {
        return iioItemName;
    }

    public void setIioItemName(String iioItemName) {
        this.iioItemName = iioItemName;
    }

    public BigDecimal getIioItemPrice() {
        return iioItemPrice;
    }

    public void setIioItemPrice(BigDecimal iioItemPrice) {
        this.iioItemPrice = iioItemPrice;
    }

    public Integer getIioItemCount() {
        return iioItemCount;
    }

    public void setIioItemCount(Integer iioItemCount) {
        this.iioItemCount = iioItemCount;
    }
}                 **/
