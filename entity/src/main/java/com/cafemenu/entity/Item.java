package com.cafemenu.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // IDENTITY - use for H2 DB, instead SEQUENCE
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
    //@SequenceGenerator(name="id_seq", sequenceName = "id_sequence", allocationSize = 1, initialValue = 1)        // allocationSize - values count in sequence per database operation, more = DB less loaded, but many values wasted useless...
    @Column(name = "item_id", updatable = false, nullable = false)
    private Integer itemId;

    @Column(name = "item_name", length = 255, unique = false, nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private BigDecimal itemPrice;


    // Getters & Setters
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}