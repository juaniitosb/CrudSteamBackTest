package com.example.steamTest.commons.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Game")
public class GameEntity {
    @Id
    @Column(name = "id_game")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_game;

    @Column(name = "name_game")
    private String nameGame;

    @Column(name = "description")
    private String description;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "game_rating")
    private String gameRating;




//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER )
//    private List<GameEntity> hours_game = new ArrayList<>();

}

