package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Hour;
import com.enamduateknologi.teknikaltest.domain.OpenHour;
import com.enamduateknologi.teknikaltest.dto.OpenHourDto;
import com.enamduateknologi.teknikaltest.repository.OpenHourRepository;
import com.enamduateknologi.teknikaltest.service.OpenHourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenHourServiceImpl implements OpenHourService {

    @Autowired
    private OpenHourRepository openHourRepository;

    @Override
    public void saveOpenHour(List<OpenHourDto> openHourDtoList, String hourId) {
        Hour hour = new Hour();
        hour.setId(hourId);
        deleteByHourId(hourId);
        for (OpenHourDto openHourDto : openHourDtoList) {
            OpenHour openHour = new OpenHour();
            openHour.setIsOvernight(openHourDto.getIsOvernight());
            openHour.setStart(openHourDto.getStart());
            openHour.setEnd(openHourDto.getEnd());
            openHour.setDay(openHourDto.getDay());
            openHour.setHour(hour);
            openHourRepository.save(openHour);
        }
    }

    @Override
    public List<OpenHourDto> getAllOpenHourByHourId(String hourId) {
        List<OpenHour> openHourList = openHourRepository.findAllByHourId(hourId);
        List<OpenHourDto> openHourDtoList = new ArrayList<>();
        for (OpenHour openHour : openHourList) {
            OpenHourDto openHourDto = new OpenHourDto();
            openHourDto.setIsOvernight(openHour.getIsOvernight());
            openHourDto.setStart(openHour.getStart());
            openHourDto.setEnd(openHour.getEnd());
            openHourDto.setDay(openHour.getDay());
            openHourDtoList.add(openHourDto);
        }
        return openHourDtoList;
    }

    @Override
    public void deleteByHourId(String hourId) {
        List<OpenHour> openHourList = openHourRepository.findAllByHourId(hourId);
        for (OpenHour openHour : openHourList) {
            openHourRepository.delete(openHour);
        }
    }
}
