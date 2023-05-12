package com.enamduateknologi.teknikaltest.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "special_hours")
public class SpecialHour {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String date;
    private String end;
    private Boolean isClosed;
    private Boolean isOvernight;
    private String start;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id")
    private Business business;
}
