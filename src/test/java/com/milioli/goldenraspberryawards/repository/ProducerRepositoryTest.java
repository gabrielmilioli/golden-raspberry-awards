package com.milioli.goldenraspberryawards.repository;

import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.dto.ProducerWinIntervalDTO;
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
public class ProducerRepositoryTest {

    @Autowired
    private ProducerRepository repository;

    @Test
    public void findAll() {
        List<Producer> all = repository.findAll();
        assertThat(all).hasSize(359);
    }

    @Test
    public void findMinWinInterval() {
        List<ProducerWinIntervalDTO> list = repository.findMinWinInterval();
        assertThat(list).hasSize(94);
    }

    @Test
    public void findMaxWinInterval() {
        List<ProducerWinIntervalDTO> list = repository.findMaxWinInterval();
        assertThat(list).hasSize(94);
    }

}
