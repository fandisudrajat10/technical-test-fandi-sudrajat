package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

@Data
public class LocationDto {

    private String id;
    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String country;
    private String state;
    private String zipCode;
    private Double latitude;
    private Double longitude;
}
