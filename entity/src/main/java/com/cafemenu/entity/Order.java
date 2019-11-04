/**package com.cafemenu.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_d")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

    @Column(nullable = false)
    private Integer orderEmployeeId;

    @CreationTimestamp
    private LocalDateTime orderDateTime;



    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderEmployeeId() {
        return orderEmployeeId;
    }

    public void setOrderEmployeeId(Integer orderEmployeeId) {
        this.orderEmployeeId = orderEmployeeId;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }
}**/
