package com.enamduateknologi.teknikaltest.dto;

import lombok.Data;

@Data
public class PhotoDetailDto {

    private String photoId;
    private String url;
    private String caption;
    private Integer width;
    private Integer height;
    private Boolean isUserSubmitted;
    private String userId;
    private String label;
}
