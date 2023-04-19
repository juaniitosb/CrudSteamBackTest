package com.example.steamTest.controller;

import com.example.steamTest.commons.constans.IEndpointGameApi;
import com.example.steamTest.commons.entity.GameEntity;
import com.example.steamTest.service.GameServiceIMPL.GameServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(IEndpointGameApi.BASE_URL)
public class GameController {
    @Autowired
    private GameServiceIMPL GSIMPL;

    @GetMapping
    @RequestMapping(value = IEndpointGameApi.GET_GAME,method = RequestMethod.GET)
    public ResponseEntity<?> getPlayers(){
        //List<GameEntity> listaGames = this.GSIMPL.getGames();
        return this.GSIMPL.getGames();
    }
    @GetMapping
    @RequestMapping(value = IEndpointGameApi.GET_GAME_PLAYERS,method = RequestMethod.GET)
    public ResponseEntity<?> gameHoursTop(@PathVariable String namePlayer){
        //List<GameEntity> listaGames = this.GSIMPL.gameHoursTop(nameplayer);
        return this.GSIMPL.gameHoursTop(namePlayer);
    }

    @PostMapping
    @RequestMapping(value = IEndpointGameApi.CREATE_GAME,method = RequestMethod.POST)
    public ResponseEntity<?>  saveGame(@RequestBody GameEntity gameEntity){
        //GameEntity gameCreate =  this.GSIMPL.saveGame(gameEntity);
        return this.GSIMPL.saveGame(gameEntity);
    }


}
