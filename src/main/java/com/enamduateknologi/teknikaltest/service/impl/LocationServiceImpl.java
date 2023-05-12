package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.domain.Location;
import com.enamduateknologi.teknikaltest.dto.LocationDto;
import com.enamduateknologi.teknikaltest.repository.LocationRepository;
import com.enamduateknologi.teknikaltest.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public void saveLocation(LocationDto locationDto, String businessId) {
        Location location;
        Optional<Location> locationOptional = locationRepository.findByBusinessId(businessId);
        location = locationOptional.map(value -> toDomain(value, locationDto, businessId)).orElseGet(() -> toDomain(new Location(), locationDto, businessId));
        locationRepository.save(location);
    }

    @Override
    public LocationDto getLocationByBusinessId(String businessId) {
        Optional<Location> locationOptional = locationRepository.findByBusinessId(businessId);
        return locationOptional.map(location -> toDto(new LocationDto(), location)).orElse(null);
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        Optional<Location> locationOptional = locationRepository.findByBusinessId(businessId);
        locationOptional.ifPresent(location -> locationRepository.delete(location));
    }

    private LocationDto toDto(LocationDto locationDto, Location location) {
        locationDto.setAddress1(location.getAddress1());
        locationDto.setAddress2(location.getAddress2());
        locationDto.setAddress3(location.getAddress3());
        locationDto.setCity(location.getCity());
        locationDto.setCountry(location.getCountry());
        locationDto.setState(location.getState());
        locationDto.setZipCode(location.getZipCode());
        locationDto.setLongitude(location.getLongitude());
        locationDto.setLatitude(location.getLatitude());
        return locationDto;
    }

    private Location toDomain(Location location, LocationDto locationDto, String businessId) {
        location.setAddress1(locationDto.getAddress1());
        location.setAddress2(locationDto.getAddress2());
        location.setAddress3(locationDto.getAddress3());
        location.setCity(locationDto.getCity());
        location.setCountry(locationDto.getCountry());
        location.setState(locationDto.getState());
        location.setZipCode(locationDto.getZipCode());
        location.setLongitude(locationDto.getLongitude());
        location.setLatitude(locationDto.getLatitude());
        Business business = new Business();
        business.setId(businessId);
        location.setBusiness(business);
        return location;
    }
}
