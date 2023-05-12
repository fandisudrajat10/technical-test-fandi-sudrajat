package com.enamduateknologi.teknikaltest.web.rest;

import com.enamduateknologi.teknikaltest.dto.BusinessRequestDto;
import com.enamduateknologi.teknikaltest.dto.BusinessSearchDto;
import com.enamduateknologi.teknikaltest.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v3/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping(value = "")
    public void saveBusiness(@RequestBody BusinessRequestDto businessRequestDto){
        businessService.saveBusiness(businessRequestDto);
    }

    @PutMapping(value = "")
    public void updateBusiness(@RequestBody BusinessRequestDto businessRequestDto){
        businessService.saveBusiness(businessRequestDto);
    }


    @DeleteMapping(value = "/{businessId}")
    public void deleteBusinessById(@PathVariable String businessId){
        businessService.deleteBusinessById(businessId);
    }


    @GetMapping(value = "/Search")
    public Page<BusinessRequestDto> searchBusiness(BusinessSearchDto businessSearchDto){
        return businessService.findSearch(businessSearchDto);
    }

    @GetMapping(value = "/{id}")
    public BusinessRequestDto getBusinessById(@PathVariable String id){
        return businessService.getBusinessById(id);
    }
}
