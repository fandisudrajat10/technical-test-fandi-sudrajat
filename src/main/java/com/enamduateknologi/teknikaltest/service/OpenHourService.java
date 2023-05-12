package com.enamduateknologi.teknikaltest.service;

import com.enamduateknologi.teknikaltest.dto.OpenHourDto;

import java.util.List;

public interface OpenHourService {

    void saveOpenHour(List<OpenHourDto> openHourDtoList, String hourId);

    List<OpenHourDto> getAllOpenHourByHourId(String hourId);

    void deleteByHourId(String hourId);
}
