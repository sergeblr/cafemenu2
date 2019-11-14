package com.cafemenu.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class DateTimeFilterDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime endDateTime;

    public DateTimeFilterDTO() {
        this.startDateTime = LocalDateTime.MIN;
        this.endDateTime = LocalDateTime.MAX;
    }

}
