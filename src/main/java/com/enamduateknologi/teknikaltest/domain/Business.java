package com.enamduateknologi.teknikaltest.domain;

import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "business")
public class Business {

    @Id
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

}
