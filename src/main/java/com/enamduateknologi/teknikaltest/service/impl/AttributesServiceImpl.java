package com.enamduateknologi.teknikaltest.service.impl;

import com.enamduateknologi.teknikaltest.domain.Attributes;
import com.enamduateknologi.teknikaltest.domain.Business;
import com.enamduateknologi.teknikaltest.dto.AttributesDto;
import com.enamduateknologi.teknikaltest.repository.AttributesRepository;
import com.enamduateknologi.teknikaltest.service.AttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AttributesServiceImpl implements AttributesService {

    @Autowired
    private AttributesRepository attributesRepository;

    @Override
    public void saveAttributes(AttributesDto attributesDto, String businessId) {
        Business business = new Business();
        business.setId(businessId);

        Optional<Attributes> attributesOptional = attributesRepository.findByBusinessId(businessId);
        Attributes attributes;
        attributes = attributesOptional.orElseGet(Attributes::new);
        attributes.setBusinessTempClosed(attributesDto.getBusinessTempClosed());
        attributes.setOutdoorSeating(attributesDto.getOutdoorSeating());
        attributes.setLikeByVegans(attributesDto.getLikedByVegans());
        attributes.setLikeByVegetarians(attributesDto.getLikedByVegetarians());
        attributes.setHotAndNew(attributesDto.getHotAndNew());
        attributes.setBusiness(business);
        attributesRepository.save(attributes);

    }

    @Override
    public AttributesDto getAttributesByBusinessId(String businessId) {
        Optional<Attributes> attributesOptional = attributesRepository.findByBusinessId(businessId);
        if (attributesOptional.isPresent()) {
            AttributesDto attributesDto = new AttributesDto();
            attributesDto.setBusinessTempClosed(attributesOptional.get().getBusinessTempClosed());
            attributesDto.setLikedByVegans(attributesOptional.get().getLikeByVegans());
            attributesDto.setLikedByVegetarians(attributesOptional.get().getLikeByVegetarians());
            attributesDto.setOutdoorSeating(attributesOptional.get().getOutdoorSeating());
            attributesDto.setHotAndNew(attributesOptional.get().getHotAndNew());
            return attributesDto;
        }
        return null;
    }

    @Override
    public void deleteByBusinessId(String businessId) {
        Optional<Attributes> attributesOptional = attributesRepository.findByBusinessId(businessId);
        attributesOptional.ifPresent(attributes -> attributesRepository.delete(attributes));
    }
}
