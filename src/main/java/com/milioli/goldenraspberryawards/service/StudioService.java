package com.milioli.goldenraspberryawards.service;

import com.milioli.goldenraspberryawards.domain.Studio;
import com.milioli.goldenraspberryawards.repository.StudioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class StudioService {

    @Autowired
    private StudioRepository repository;

    public List<Studio> createFromString(String names) {

        return Stream.of(names.split(",| and "))
                .filter(s -> !s.trim().isEmpty())
                .map(name -> {
                    String nameTrim = name.trim();
                    Optional<Studio> entity = repository.findByName(nameTrim);
                    return entity.orElseGet(() -> repository.save(create(nameTrim)));
                })
                .collect(Collectors.toList());
    }

    private Studio create(String name) {
        return Studio.builder().name(name).build();
    }

}
