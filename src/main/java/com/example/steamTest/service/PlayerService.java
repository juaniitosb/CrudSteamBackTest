package com.example.steamTest.service;

import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlayerService {
    ResponseEntity<GenericResponseDTO> getPlayers();
    ResponseEntity<GenericResponseDTO> savePlayer(PlayerEntity playerEntity);

    ResponseEntity<GenericResponseDTO> getPlayersTop(String name);
}
