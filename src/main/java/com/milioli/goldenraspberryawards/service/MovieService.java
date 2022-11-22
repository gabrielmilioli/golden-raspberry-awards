package com.milioli.goldenraspberryawards.service;

import com.milioli.goldenraspberryawards.domain.Movie;
import com.milioli.goldenraspberryawards.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> saveAll(List<Movie> entities) {
        return repository.saveAll(entities);
    }

}
