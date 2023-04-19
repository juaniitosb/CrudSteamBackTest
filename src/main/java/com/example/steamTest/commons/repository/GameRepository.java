package com.example.steamTest.commons.repository;

import com.example.steamTest.commons.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameEntity,Long> {
    @Query("select g from GameEntity g inner join HoursEntity h on g.id_game = h.gameEntity.id_game " +
            "where h.playerEntity.name = :namePlayer order by h.time desc")
    List<GameEntity> gameHoursTop(String namePlayer);
}
