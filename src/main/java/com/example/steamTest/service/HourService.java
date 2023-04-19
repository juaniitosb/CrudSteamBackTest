package com.example.steamTest.service;

import com.example.steamTest.commons.entity.HoursEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.commons.generic.HoursDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface HourService {

    ResponseEntity<GenericResponseDTO> getHours();

    ResponseEntity<GenericResponseDTO> deleteHours(int id);

    ResponseEntity<GenericResponseDTO> updateHours(HoursEntity hoursEntity);

    ResponseEntity<GenericResponseDTO> saveHours(HoursDTO hoursDTO);

}
