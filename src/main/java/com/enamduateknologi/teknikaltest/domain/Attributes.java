package com.enamduateknologi.teknikaltest.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "attributes")
public class Attributes {


    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Long businessTempClosed;
    private Boolean outdoorSeating;
    private Boolean likeByVegans;
    private Boolean likeByVegetarians;
    private String hotAndNew;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;
}
