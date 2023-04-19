package com.example.steamTest.service;

import com.example.steamTest.commons.entity.GameEntity;
import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GameService {
     ResponseEntity<GenericResponseDTO> getGames();

     ResponseEntity<GenericResponseDTO> gameHoursTop(String namePlayer);

     ResponseEntity<GenericResponseDTO> saveGame(GameEntity gameEntity);
}
