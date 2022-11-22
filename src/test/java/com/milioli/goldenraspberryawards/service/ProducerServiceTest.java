package com.milioli.goldenraspberryawards.service;

import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.repository.ProducerRepository;
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
public class ProducerServiceTest {

    @Autowired
    private ProducerService service;

    @Autowired
    private ProducerRepository repository;

    @Test
    public void createFromString() {

        List<Producer> entities = service.createFromString("Teste Não Existente");

        assertThat(entities).hasSize(1);
        assertThat(repository.findByName("Teste Não Existente")).isPresent();
    }

    @Test
    public void createFromStringExistente() {

        assertThat(repository.findByName("Allan Carr")).isPresent();

        List<Producer> entities = service.createFromString("Allan Carr");

        assertThat(entities).hasSize(1);
    }

}
