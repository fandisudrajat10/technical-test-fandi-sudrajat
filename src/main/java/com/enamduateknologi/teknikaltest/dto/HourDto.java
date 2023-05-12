package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

import java.util.List;

@Data
public class HourDto {

    private String hoursType;
    private Boolean isOpenNow;
    private List<OpenHourDto> open;
}
