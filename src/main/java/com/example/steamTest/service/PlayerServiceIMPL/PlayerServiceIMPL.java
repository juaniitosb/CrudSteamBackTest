package com.example.steamTest.service.PlayerServiceIMPL;

import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.commons.repository.PlayerRepository;
import com.example.steamTest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceIMPL implements PlayerService {
    @Autowired
    private PlayerRepository playerRepository;


    @Override
    public ResponseEntity<GenericResponseDTO> savePlayer(PlayerEntity playerEntity) {
        try {
            playerRepository.save(playerEntity);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Players created")
                    .objectResponse(playerEntity)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error player creating:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<GenericResponseDTO> getPlayers() {
        try {
            List<PlayerEntity> playerLs = playerRepository.findAll();
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("list of players found")
                    .objectResponse(playerLs)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error showing list of players:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @Override
    public ResponseEntity<GenericResponseDTO> getPlayersTop(String nameGame) {
        try {
            List<PlayerEntity> listTopPlayers = playerRepository.getPlayersTop(nameGame);
            listTopPlayers = listTopPlayers.stream().limit(10).toList();
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("list of tops found")
                    .objectResponse(listTopPlayers)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error showing list of tops:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
