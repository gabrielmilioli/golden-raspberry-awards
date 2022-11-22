package com.milioli.goldenraspberryawards.repository;

import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.domain.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

    Optional<Studio> findByName(String name);

}
