/**package com.cafemenu.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDTO {

    private Integer orderId;

    private Integer employeeId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDateTime;

    private BigDecimal summaryPrice;

    private Integer itemsQuantity;

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(LocalDateTime orderDateTime) { this.orderDateTime = orderDateTime; }

    public BigDecimal getSummaryPrice() { return summaryPrice; }
    public void setSummaryPrice(BigDecimal summaryPrice) { this.summaryPrice = summaryPrice; }

    public Integer getItemsQuantity() { return itemsQuantity; }
    public void setItemsQuantity(Integer itemsQuantity) { this.itemsQuantity = itemsQuantity; }
}**/
