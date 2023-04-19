package com.example.steamTest.controller;

import com.example.steamTest.commons.constans.IEndpointPlayerApi;
import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.GenericResponseDTO;
import com.example.steamTest.service.PlayerServiceIMPL.PlayerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(IEndpointPlayerApi.BASE_URL)
public class PlayerController {
    @Autowired
    private PlayerServiceIMPL PSIMPL;

    @GetMapping
    @RequestMapping(value = IEndpointPlayerApi.GET_PLAYER,method = RequestMethod.GET)
    public  ResponseEntity<GenericResponseDTO> getPlayers(){
        return this.PSIMPL.getPlayers();
    }
    @GetMapping
    @RequestMapping(value = IEndpointPlayerApi.GET_PLAYER_TOP,method = RequestMethod.GET)
    public ResponseEntity<?> getPlayersTop(@PathVariable String nameGame){
        return this.PSIMPL.getPlayersTop(nameGame);
    }

    @PostMapping(IEndpointPlayerApi.CREATE_PLAYER)
    @RequestMapping(value = IEndpointPlayerApi.CREATE_PLAYER,method = RequestMethod.POST)
    public ResponseEntity<?> savePlayer(@RequestBody PlayerEntity playerEntity){
        return this.PSIMPL.savePlayer(playerEntity);
    }
}
