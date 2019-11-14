package com.cafemenu.DTO;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private Integer orderId;

    private Integer employeeId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderDateTime;

    private BigDecimal summaryPrice;

    private Integer itemsQuantity;

}
