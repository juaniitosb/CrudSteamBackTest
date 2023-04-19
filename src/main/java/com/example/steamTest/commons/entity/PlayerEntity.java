package com.example.steamTest.commons.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Player")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_player")
    private Long id_player;

    @Column(name = "alias_name")
    private String alias_name;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private String gender;

//Relacion uno a muchos pero pierde performance al ser mucha data
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<HoursEntity> hours_player = new HashSet<>();

}
