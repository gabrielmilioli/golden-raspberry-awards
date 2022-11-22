package com.milioli.goldenraspberryawards.repository;

import com.milioli.goldenraspberryawards.domain.Movie;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository repository;

    @Test
    public void findAll() {
        List<Movie> all = repository.findAll();
        assertThat(all).hasSize(206);
    }

}
