package com.milioli.goldenraspberryawards.service;

import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.dto.ProducerIntervalDTO;
import com.milioli.goldenraspberryawards.repository.ProducerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class ProducerService {

    @Autowired
    private ProducerRepository repository;

    public ProducerIntervalDTO getIntervalWins() {
        return new ProducerIntervalDTO(
                repository.findMinWinInterval(),
                repository.findMaxWinInterval()
        );
    }

    public List<Producer> createFromString(String names) {

        return Stream.of(names.split(",| and "))
                .filter(s -> !s.trim().isEmpty())
                .map(name -> {
                    String nameTrim = name.trim();
                    Optional<Producer> entity = repository.findByName(nameTrim);
                    return entity.orElseGet(() -> repository.save(create(nameTrim)));
                })
                .collect(Collectors.toList());
    }

    private Producer create(String name) {
        return Producer.builder().name(name).build();
    }

}
