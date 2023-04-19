package com.example.steamTest.commons.repository;

import com.example.steamTest.commons.entity.HoursEntity;
import com.example.steamTest.commons.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoursRepository extends JpaRepository<HoursEntity,Long> {

}
