package com.example.steamTest.service.HourServiceIMPL;

import com.example.steamTest.commons.entity.GameEntity;
import com.example.steamTest.commons.entity.HoursEntity;
import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.commons.generic.HoursDTO;
import com.example.steamTest.commons.repository.GameRepository;
import com.example.steamTest.commons.repository.HoursRepository;
import com.example.steamTest.commons.repository.PlayerRepository;
import com.example.steamTest.service.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HourServiceIMPL implements HourService {

    @Autowired
    private HoursRepository hoursRepository;
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameRepository gameRepository;

    @Override
    public ResponseEntity<GenericResponseDTO> getHours() {
        try {
            List<HoursEntity> hourLS = this.hoursRepository.findAll();
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("list of hours found")
                    .objectResponse(hourLS)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error showing list of hours:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<GenericResponseDTO> saveHours(HoursDTO hoursDTO) {
        GameEntity gameEntity = gameRepository.findById(hoursDTO.getId_game()).get();
        PlayerEntity playerEntity = playerRepository.findById(hoursDTO.getId_player()).get();
        List<HoursEntity> hourLs= this.hoursRepository.findAll();
        HoursEntity hoursEntity = new HoursEntity( null, (int) hoursDTO.getTime(),null,null);
        try {
            hourLs.forEach((d)->{
                if (d.getGameEntity().equals(gameEntity) && d.getPlayerEntity().equals(playerEntity)) {
                    hoursEntity.setId_hours(d.getId_hours());
                    hoursEntity.setTime((int) (d.getTime() + hoursDTO.getTime()));
                }
            });

            hoursEntity.setPlayerEntity(playerEntity);
            hoursEntity.setGameEntity(gameEntity);
            this.hoursRepository.save(hoursEntity);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Hours Created")
                    .objectResponse(hoursEntity)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("error Hour Created:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> deleteHours(int id) {
        try {
            this.hoursRepository.deleteById((long) id);
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Hour delete")
                    .objectResponse(null)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error Delete Hour:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<GenericResponseDTO> updateHours(HoursEntity hoursEntity) {
        try {
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Update Hour")
                    .objectResponse(null)
                    .statusCode(HttpStatus.OK.value())
                    .build(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(GenericResponseDTO.builder()
                    .message("Error update hour:  " + e.getMessage())
                    .objectResponse(null)
                    .statusCode(HttpStatus.BAD_REQUEST.value())
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }


}
