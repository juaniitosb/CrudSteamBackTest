package com.example.steamTest;

import com.example.steamTest.commons.entity.GameEntity;
import com.example.steamTest.commons.entity.HoursEntity;
import com.example.steamTest.commons.entity.PlayerEntity;
import com.example.steamTest.commons.generic.HoursDTO;
import com.example.steamTest.commons.repository.GameRepository;
import com.example.steamTest.commons.repository.HoursRepository;
import com.example.steamTest.commons.repository.PlayerRepository;
import com.example.steamTest.controller.HoursController;
import com.example.steamTest.service.HourServiceIMPL.HourServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SteamTestApplication {

    @Autowired
    private PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SteamTestApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepo, GameRepository gameRepo, HoursController hoursContr) {

        return args -> {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formato.parse("23/11/2015");
            PlayerEntity player1 = playerRepo.save(new PlayerEntity(null, "Dark", "juan", "sanchez", "j@gmail.com", 25, "m"));
            PlayerEntity player2 = playerRepo.save(new PlayerEntity(null, "Princesa", "sol", "trujillo", "j@gmail.com", 22, "f"));
            PlayerEntity player3 = playerRepo.save(new PlayerEntity(null, "parca", "juana", "sanchez", "j@gmail.com", 25, "f"));
            PlayerEntity player4 = playerRepo.save(new PlayerEntity(null, "assasin", "felicia", "mndez", "j@gmail.com", 25, "m"));
            PlayerEntity player5 = playerRepo.save(new PlayerEntity(null, "templario", "oscar", "perez", "j@gmail.com", 25, "m"));
            PlayerEntity player6 = playerRepo.save(new PlayerEntity(null, "Dark321", "jhon", "tijo", "j@gmail.com", 25, "f"));
            PlayerEntity player7 = playerRepo.save(new PlayerEntity(null, "Dark987", "jairo", "jolo", "j@gmail.com", 25, "m"));
            GameEntity game1 = gameRepo.save(new GameEntity(null, "Fortnite", "mundo abierto", fecha, "prueba"));
            GameEntity game2 = gameRepo.save(new GameEntity(null, "Dark", "mundo abierto", fecha, "prueba"));
            GameEntity game3 = gameRepo.save(new GameEntity(null, "Alone", "mundo abierto", fecha, "prueba"));
            GameEntity game4 = gameRepo.save(new GameEntity(null, "Fortnite", "mundo abierto", fecha, "prueba"));
            GameEntity game5 = gameRepo.save(new GameEntity(null, "The witcher", "mundo abierto", fecha, "prueba"));
            GameEntity game6 = gameRepo.save(new GameEntity(null, "Halo 2", "mundo abierto", fecha, "prueba"));
            GameEntity game7 = gameRepo.save(new GameEntity(null, "Warzone", "mundo abierto", fecha, "prueba"));
            GameEntity game8 = gameRepo.save(new GameEntity(null, "Watch dogs", "mundo abierto", fecha, "prueba"));
            GameEntity game9 = gameRepo.save(new GameEntity(null, "Far cry", "mundo abierto", fecha, "prueba"));
            GameEntity game10 = gameRepo.save(new GameEntity(null, "League of Legends", "mundo abierto", fecha, "prueba"));
        };
    }


}
