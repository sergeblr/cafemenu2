package com.cafemenu.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class IioKey implements Serializable {

    private OrderD order_iio;
    //private Integer iioOrderId;

    private Integer iioItemId;

}
