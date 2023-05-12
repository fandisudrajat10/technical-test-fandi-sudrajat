package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.dto.*;
import com.enamduateknologi.teknikaltest.repository.BusinessDataRepository;
import com.enamduateknologi.teknikaltest.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDataRepository businessRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private PhotoDetailService photoDetailService;

    @Autowired
    private BusinessCategoryService businessCategoryService;

    @Autowired
    private SpecialHourService specialHoursService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private HourService hourService;

    @Autowired
    private AttributesService attributesService;


    @Override
    public void saveBusiness(BusinessRequestDto businessRequestDto) {

        Business business;
        Optional<Business> businessOptional = businessRepository.findById(businessRequestDto.getId());
        business = businessOptional.map(value -> toDomain(value, businessRequestDto)).orElseGet(() -> toDomain(new Business(), businessRequestDto));

        businessRepository.save(business);

        locationService.saveLocation(businessRequestDto.getLocation(), businessRequestDto.getId());

        photoDetailService.savePhotoDetail(businessRequestDto.getPhotoDetails(), businessRequestDto.getId());

        businessCategoryService.saveBusinessCategory(businessRequestDto.getCategories(), businessRequestDto.getId());

        specialHoursService.saveSpecialHours(businessRequestDto.getSpecialHours(), businessRequestDto.getId());

        transactionService.saveTransaction(businessRequestDto.getTransactions(), businessRequestDto.getId());

        hourService.saveHour(businessRequestDto.getHours(), businessRequestDto.getId());

        attributesService.saveAttributes(businessRequestDto.getAttributes(), businessRequestDto.getId());

    }


    @Override
    public BusinessRequestDto getBusinessById(String id) {
        Optional<Business> businessOptional = businessRepository.findById(id);
        if (businessOptional.isPresent()) {
            BusinessRequestDto businessRequestDto = toDto(businessOptional.get());
            LocationDto locationDto = locationService.getLocationByBusinessId(id);
            businessRequestDto.setLocation(locationDto);
            List<PhotoDetailDto> photoDetailDtoList = photoDetailService.getAllPhotoDetailByBusinessId(id);
            businessRequestDto.setPhotoDetails(photoDetailDtoList);
            List<CategoryDto> categories = businessCategoryService.getAllCategoryByBusinessId(id);
            businessRequestDto.setCategories(categories);
            List<SpecialHourDto> specialHoursDtoList = specialHoursService.getAllSpecialHoursByBusinessId(id);
            businessRequestDto.setSpecialHours(specialHoursDtoList);
            List<String> transactionList = transactionService.getAllTransactionTypeByBusinessId(id);
            businessRequestDto.setTransactions(transactionList);
            HourDto hours = hourService.getHourByBusinessId(id);
            businessRequestDto.setHours(hours);
            AttributesDto attributes = attributesService.getAttributesByBusinessId(id);
            businessRequestDto.setAttributes(attributes);
            return businessRequestDto;
        } else {
            return null;
        }
    }

    @Override
    public void deleteBusinessById(String businessId) {
        Optional<Business> businessOptional = businessRepository.findById(businessId);
        if (businessOptional.isPresent()){
            businessCategoryService.deleteByBusinessId(businessId);

            locationService.deleteByBusinessId(businessId);

            photoDetailService.deleteByBusinessId(businessId);


            specialHoursService.deleteByBusinessId(businessId);

            transactionService.deleteByBusinessId(businessId);

            hourService.deleteByBusinessId(businessId);

            attributesService.deleteByBusinessId(businessId);
            businessRepository.deleteById(businessId);
        }

    }

    @Override
    public Page<BusinessRequestDto> findSearch(BusinessSearchDto businessSearchDto) {
        return null;
    }


    private BusinessRequestDto toDto(Business business) {
        BusinessRequestDto businessRequestDto = new BusinessRequestDto();
        businessRequestDto.setId(business.getId());
        businessRequestDto.setAlias(business.getAlias());
        businessRequestDto.setDisplayPhone(business.getDisplayPhone());
        businessRequestDto.setDistance(business.getDistance());
        businessRequestDto.setImageUrl(business.getImageUrl());
        businessRequestDto.setClaimed(business.getClaimed());
        businessRequestDto.setClosed(business.getClosed());
        businessRequestDto.setDateOpened(business.getDateOpened());
        businessRequestDto.setDateClosed(business.getDateClosed());
        businessRequestDto.setName(business.getName());
        businessRequestDto.setPhone(business.getPhone());
        businessRequestDto.setPrice(business.getPrice());
        businessRequestDto.setRating(business.getRating());
        businessRequestDto.setReviewCount(business.getReviewCount());
        businessRequestDto.setUrl(business.getUrl());
        businessRequestDto.setYelpMenuUrl(business.getYelpMenuUrl());
        return businessRequestDto;
    }

    private Business toDomain(Business business, BusinessRequestDto businessRequestDto) {
        business.setId(businessRequestDto.getId());
        business.setAlias(businessRequestDto.getAlias());
        business.setDisplayPhone(businessRequestDto.getDisplayPhone());
        business.setDistance(businessRequestDto.getDistance());
        business.setImageUrl(businessRequestDto.getImageUrl());
        business.setClaimed(businessRequestDto.getClaimed());
        business.setClosed(businessRequestDto.getClosed());
        business.setDateOpened(businessRequestDto.getDateOpened());
        business.setDateClosed(businessRequestDto.getDateClosed());
        business.setName(businessRequestDto.getName());
        business.setPhone(businessRequestDto.getPhone());
        business.setPrice(businessRequestDto.getPrice());
        business.setRating(businessRequestDto.getRating());
        business.setReviewCount(businessRequestDto.getReviewCount());
        business.setUrl(businessRequestDto.getUrl());
        business.setYelpMenuUrl(businessRequestDto.getYelpMenuUrl());
        return business;
    }
}
