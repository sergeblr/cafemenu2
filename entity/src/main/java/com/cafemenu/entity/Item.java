package com.cafemenu.entity;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {
    /**
     * Item ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer itemId;

    /**
     * Item name
     */
    
    private String itemName;

    /**
     * Item price
     */
    private BigDecimal itemPrice;

}