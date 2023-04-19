package com.example.steamTest.commons.repository;

import com.example.steamTest.commons.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {

    @Query("select p from PlayerEntity p inner join HoursEntity h on p.id_player = h.playerEntity.id_player " +
            "inner join GameEntity g on h.gameEntity.id_game = g.id_game where g.nameGame = :nameGame " +
            " order by h.time desc")
    List<PlayerEntity> getPlayersTop(String nameGame);
}
