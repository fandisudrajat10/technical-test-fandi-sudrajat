package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.SpecialHour;
import com.enamduateknologi.teknikaltest.dto.SpecialHourDto;
import com.enamduateknologi.teknikaltest.repository.SpecialHourRepository;
import com.enamduateknologi.teknikaltest.service.SpecialHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpecialHourServiceImpl implements SpecialHourService {

    @Autowired
    private SpecialHourRepository specialHoursRepository;

    @Override
    public void saveSpecialHours(List<SpecialHourDto> specialHoursDtos, String businessId) {
        deleteByBusinessId(businessId);
        for (SpecialHourDto specialHoursDto : specialHoursDtos) {
            SpecialHour specialHours = new SpecialHour();
            specialHours.setDate(specialHoursDto.getDate());
            specialHours.setEnd(specialHoursDto.getEnd());
            specialHours.setIsClosed(specialHoursDto.getIsClosed());
            specialHours.setIsOvernight(specialHoursDto.getIsOvernight());
            specialHours.setStart(specialHoursDto.getStart());
            Business business = new Business();
            business.setId(businessId);
            specialHours.setBusiness(business);
            specialHoursRepository.save(specialHours);
        }
    }

    @Override
    public List<SpecialHourDto> getAllSpecialHoursByBusinessId(String businessId) {
        List<SpecialHour> specialHoursList = specialHoursRepository.findAllByBusinessId(businessId);
        List<SpecialHourDto> specialHoursDtoList = new ArrayList<>();
        for (SpecialHour specialHours : specialHoursList) {
            SpecialHourDto specialHoursDto = new SpecialHourDto();
            specialHoursDto.setDate(specialHours.getDate());
            specialHoursDto.setEnd(specialHours.getEnd());
            specialHoursDto.setIsClosed(specialHours.getIsClosed());
            specialHoursDto.setIsOvernight(specialHours.getIsOvernight());
            specialHoursDto.setStart(specialHours.getStart());
            specialHoursDtoList.add(specialHoursDto);
        }
        return specialHoursDtoList;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        List<SpecialHour> specialHoursList = specialHoursRepository.findAllByBusinessId(businessId);
        for (SpecialHour specialHours : specialHoursList) {
            specialHoursRepository.delete(specialHours);
        }
    }
}
