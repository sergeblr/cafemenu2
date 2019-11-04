/**package com.cafemenu.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class DateTimeFilterDTO {

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    LocalDateTime endDateTime;

    public DateTimeFilterDTO() {
        this.startDateTime = LocalDateTime.MIN;
        this.endDateTime = LocalDateTime.MAX;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }
}**/
