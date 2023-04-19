package com.example.steamTest.commons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Hours")
public class HoursEntity {
    @Id
    @Column(name = "id_hours")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_hours;

    @Column(name = "time")
    private Integer time;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_player")
    private PlayerEntity playerEntity;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_game")
    private GameEntity gameEntity;


}
