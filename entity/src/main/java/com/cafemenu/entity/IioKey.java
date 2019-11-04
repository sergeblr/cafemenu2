/**package com.cafemenu.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class IioKey implements Serializable {
    protected Integer orderId;
    protected Integer itemId;

    public IioKey() {
        //
    }

    public IioKey(Integer orderId, Integer itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }
}
**/