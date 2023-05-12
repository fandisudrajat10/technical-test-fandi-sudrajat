package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

import java.util.List;

@Data
public class BusinessRequestDto {

    private String id;
    private String alias;
    private String displayPhone;
    private Double distance;
    private String imageUrl;
    private Boolean claimed;
    private Boolean closed;
    private String dateOpened;
    private String dateClosed;
    private String name;
    private String phone;
    private String price;
    private Double rating;
    private Integer reviewCount;
    private String url;
    private String yelpMenuUrl;
    private LocationDto location;
    private List<PhotoDetailDto> photoDetails;
    private List<CategoryDto> categories;
    private List<SpecialHourDto> specialHours;
    private List<String> transactions;
    private HourDto hours;
    private AttributesDto attributes;
}
