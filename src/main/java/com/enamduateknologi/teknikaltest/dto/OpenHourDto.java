package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

@Data
public class OpenHourDto {
    private Boolean isOvernight;
    private Integer start;
    private Integer end;
    private Integer day;
}
