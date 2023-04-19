package com.example.steamTest.service.GameServiceIMPL;

import com.example.steamTest.commons.entity.GameEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.commons.repository.GameRepository;
import com.example.steamTest.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GameServiceIMPL implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public ResponseEntity<GenericResponseDTO> getGames() {
        try {
            //return (List<GameEntity>) gameRepository.findAll();
             List<GameEntity> gameLs = gameRepository.findAll();
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("list of games found")
                    .objectResponse(gameLs)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error showing list of games:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<GenericResponseDTO> gameHoursTop(String namePlayer) {
        try {
            List<GameEntity> listGameTop = gameRepository.gameHoursTop(namePlayer);
            listGameTop = listGameTop.stream().limit(10).toList();
            //return listGameTop;
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("list of tops found")
                    .objectResponse(listGameTop)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error showing list of tops:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<GenericResponseDTO> saveGame(GameEntity gameEntity) {
        try {
            this.gameRepository.save(gameEntity);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Game created")
                    .objectResponse(gameEntity)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error player creating:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
