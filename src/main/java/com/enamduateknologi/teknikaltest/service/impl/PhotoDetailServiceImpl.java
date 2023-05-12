package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.PhotoDetail;
import com.enamduateknologi.teknikaltest.dto.PhotoDetailDto;
import com.enamduateknologi.teknikaltest.repository.PhotoDetailRepository;
import com.enamduateknologi.teknikaltest.service.PhotoDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoDetailServiceImpl implements PhotoDetailService {

    @Autowired
    private PhotoDetailRepository photoDetailRepository;


    @Override
    public void savePhotoDetail(List<PhotoDetailDto> photoDetailDtoList, String businessId) {
        deleteByBusinessId(businessId);
        for (PhotoDetailDto photoDetailDto : photoDetailDtoList) {
            PhotoDetail photoDetail = toDomain(new PhotoDetail(), photoDetailDto, businessId);
            photoDetailRepository.save(photoDetail);
        }
    }

    @Override
    public List<PhotoDetailDto> getAllPhotoDetailByBusinessId(String businessId) {
        List<PhotoDetail> photoDetailList = photoDetailRepository.findAllByBusinessId(businessId);
        List<PhotoDetailDto> photoDetailDtoList = new ArrayList<>();
        for (PhotoDetail photoDetail : photoDetailList) {
            PhotoDetailDto photoDetailDto = toDto(photoDetail);
            photoDetailDtoList.add(photoDetailDto);
        }
        return photoDetailDtoList;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        List<PhotoDetail> photoDetailList = photoDetailRepository.findAllByBusinessId(businessId);
        for (PhotoDetail photoDetail : photoDetailList) {
            photoDetailRepository.delete(photoDetail);
        }
    }

    private PhotoDetailDto toDto(PhotoDetail photoDetail) {
        PhotoDetailDto photoDetailDto = new PhotoDetailDto();
        photoDetailDto.setPhotoId(photoDetail.getPhotoId());
        photoDetailDto.setUrl(photoDetail.getUrl());
        photoDetailDto.setCaption(photoDetail.getCaption());
        photoDetailDto.setWidth(photoDetail.getWidth());
        photoDetailDto.setHeight(photoDetail.getHeight());
        photoDetailDto.setIsUserSubmitted(photoDetail.getIsUserSubmitted());
        photoDetailDto.setUserId(photoDetail.getUserId());
        photoDetailDto.setLabel(photoDetail.getLabel());
        return photoDetailDto;
    }

    private PhotoDetail toDomain(PhotoDetail photoDetail, PhotoDetailDto photoDetailDto, String businessId) {
        photoDetail.setPhotoId(photoDetailDto.getPhotoId());
        photoDetail.setUrl(photoDetailDto.getUrl());
        photoDetail.setCaption(photoDetailDto.getCaption());
        photoDetail.setWidth(photoDetailDto.getWidth());
        photoDetail.setHeight(photoDetailDto.getHeight());
        photoDetail.setIsUserSubmitted(photoDetailDto.getIsUserSubmitted());
        photoDetail.setUserId(photoDetailDto.getUserId());
        photoDetail.setLabel(photoDetailDto.getLabel());
        Business business = new Business();
        business.setId(businessId);
        photoDetail.setBusiness(business);
        return photoDetail;
    }
}
