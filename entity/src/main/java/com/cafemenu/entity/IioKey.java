package com.cafemenu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
public class IioKey implements Serializable {

    private Integer orderId;

    private Integer itemId;

/*    public IioKey() {
        //
    }

    public IioKey(Integer orderId, Integer itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }*/
}
