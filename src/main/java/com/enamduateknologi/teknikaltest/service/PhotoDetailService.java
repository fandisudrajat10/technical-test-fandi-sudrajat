package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.PhotoDetailDto;

import java.util.List;

public interface PhotoDetailService {

    void savePhotoDetail(List<PhotoDetailDto> photoDetailDtoList, String businessId);

    List<PhotoDetailDto> getAllPhotoDetailByBusinessId(String businessId);

    void deleteByBusinessId(String businessId);
}
