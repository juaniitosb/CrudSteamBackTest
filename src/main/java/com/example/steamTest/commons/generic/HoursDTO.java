package com.example.steamTest.commons.generic;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class HoursDTO {
    private long time;
    private long id_player;
    private long id_game;
}
