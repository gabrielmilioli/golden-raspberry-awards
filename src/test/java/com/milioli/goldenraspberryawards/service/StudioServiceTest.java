package com.milioli.goldenraspberryawards.service;

import com.milioli.goldenraspberryawards.domain.Studio;
import com.milioli.goldenraspberryawards.repository.StudioRepository;
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
public class StudioServiceTest {

    @Autowired
    private StudioService service;

    @Autowired
    private StudioRepository repository;

    @Test
    public void createFromString() {

        List<Studio> entities = service.createFromString("Teste Não Existente");

        assertThat(entities).hasSize(1);
        assertThat(repository.findByName("Teste Não Existente")).isPresent();
    }

    @Test
    public void createFromStringExistente() {

        assertThat(repository.findByName("Universal Studios")).isPresent();

        List<Studio> entities = service.createFromString("Universal Studios");

        assertThat(entities).hasSize(1);
    }

}
