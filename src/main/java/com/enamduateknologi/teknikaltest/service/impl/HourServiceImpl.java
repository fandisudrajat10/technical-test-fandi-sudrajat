package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.Hour;
import com.enamduateknologi.teknikaltest.dto.HourDto;
import com.enamduateknologi.teknikaltest.dto.OpenHourDto;
import com.enamduateknologi.teknikaltest.repository.HourRepository;
import com.enamduateknologi.teknikaltest.service.HourService;
import com.enamduateknologi.teknikaltest.service.OpenHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HourServiceImpl implements HourService {

    @Autowired
    private HourRepository hourRepository;

    @Autowired
    private OpenHourService openHourService;

    @Override
    public void saveHour(HourDto hourDto, String businessId) {
        Optional<Hour> hourOptional = hourRepository.findByBusinessId(businessId);
        Hour hour;
        hour = hourOptional.orElseGet(Hour::new);
        hour.setHourType(hourDto.getHoursType());
        hour.setIsOpenNow(hourDto.getIsOpenNow());
        Business business = new Business();
        business.setId(businessId);
        hour.setBusiness(business);
        Hour hourSave = hourRepository.save(hour);
        openHourService.saveOpenHour(hourDto.getOpen(), hourSave.getId());
    }

    @Override
    public HourDto getHourByBusinessId(String businessId) {
        Optional<Hour> hourOptional = hourRepository.findByBusinessId(businessId);
        HourDto hourDto = new HourDto();
        if (hourOptional.isPresent()) {
            hourDto.setHoursType(hourOptional.get().getHourType());
            hourDto.setIsOpenNow(hourOptional.get().getIsOpenNow());
            List<OpenHourDto> openHourDtoList = openHourService.getAllOpenHourByHourId(hourOptional.get().getId());
            hourDto.setOpen(openHourDtoList);
        }
        return hourDto;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        Optional<Hour> hourOptional = hourRepository.findByBusinessId(businessId);
        openHourService.deleteByHourId(hourOptional.get().getId());
        hourOptional.ifPresent(hour -> hourRepository.delete(hour));
    }
}
