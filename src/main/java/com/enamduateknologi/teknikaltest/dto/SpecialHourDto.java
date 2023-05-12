package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

@Data
public class SpecialHourDto {
    private String date;
    private String end;
    private Boolean isClosed;
    private Boolean isOvernight;
    private String start;
}
