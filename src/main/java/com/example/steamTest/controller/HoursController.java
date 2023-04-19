package com.example.steamTest.controller;

import com.example.steamTest.commons.constans.IEndpointHoursApi;
import com.example.steamTest.commons.entity.HoursEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.commons.generic.HoursDTO;
import com.example.steamTest.service.HourServiceIMPL.HourServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(IEndpointHoursApi.BASE_URL)
public class HoursController {
    @Autowired
    private HourServiceIMPL HSIMPL;

    @GetMapping
    @RequestMapping(value = IEndpointHoursApi.GET_HOURS, method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDTO> getHours() {
        return this.HSIMPL.getHours();
    }

    @PostMapping
    @RequestMapping(value = IEndpointHoursApi.CREATE_HOURS, method = RequestMethod.POST)
    public ResponseEntity<?> SaveHours(@RequestBody HoursDTO hoursDTO) {
        return this.HSIMPL.saveHours(hoursDTO);
    }

    @DeleteMapping
    @RequestMapping(value = IEndpointHoursApi.DELETE_HOURS, method = RequestMethod.DELETE)
    public ResponseEntity<GenericResponseDTO> deleteHours(@PathVariable int id_hour) {
      return   this.HSIMPL.deleteHours(id_hour);
    }
}
