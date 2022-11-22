package com.milioli.goldenraspberryawards.service;

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
public class MovieServiceTest {

    @Autowired
    private MovieService service;

    @Test
    public void saveAll() {
        List<Movie> entities = service.saveAll(List.of(
                Movie.builder().title("Teste").year(2022L).winner(Boolean.TRUE).build()
        ));

        assertThat(entities).hasSize(1);
    }

}
