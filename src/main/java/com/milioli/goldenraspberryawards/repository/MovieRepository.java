package com.milioli.goldenraspberryawards.repository;

import com.milioli.goldenraspberryawards.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
