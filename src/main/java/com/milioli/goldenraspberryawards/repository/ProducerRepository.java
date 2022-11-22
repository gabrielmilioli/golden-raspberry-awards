package com.milioli.goldenraspberryawards.repository;

import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.dto.ProducerWinIntervalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    String SELECT_MIN_YEAR = " (SELECT MIN(m.year) "
            + " FROM Movie m "
            + " INNER JOIN m.producers mp "
            + " WHERE mp.id = p.id "
            + " AND m.winner = TRUE) ";

    String SELECT_MAX_YEAR = " (SELECT MAX(m.year) "
            + " FROM Movie m "
            + " INNER JOIN m.producers mp "
            + " WHERE mp.id = p.id "
            + " AND m.winner = TRUE) ";

    String WHERE_WINNER = " EXISTS (SELECT m.id "
            + " FROM Movie m "
            + " INNER JOIN m.producers mp "
            + " WHERE mp.id = p.id "
            + " AND m.winner = TRUE) ";

    String SELECT_DTO = " SELECT new com.milioli.goldenraspberryawards.dto.ProducerWinIntervalDTO ( "
            + " p.name, "
            + " ( " + SELECT_MAX_YEAR + " - " + SELECT_MIN_YEAR + " ), "
            + SELECT_MIN_YEAR + ", "
            + SELECT_MAX_YEAR
            + " ) "
            + " FROM Producer p "
            + " WHERE " + WHERE_WINNER;

    Optional<Producer> findByName(String name);

    @Query(SELECT_DTO + " ORDER BY 2, 1 ")
    List<ProducerWinIntervalDTO> findMinWinInterval();

    @Query(SELECT_DTO + " ORDER BY 2 DESC, 1 ASC ")
    List<ProducerWinIntervalDTO> findMaxWinInterval();

}
