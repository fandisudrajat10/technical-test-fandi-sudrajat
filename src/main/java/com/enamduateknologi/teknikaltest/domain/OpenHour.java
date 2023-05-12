package com.enamduateknologi.teknikaltest.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "open_hour")
public class OpenHour {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private Boolean isOvernight;
    private Integer start;
    private Integer end;
    private Integer day;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hour_id")
    private Hour hour;
}
