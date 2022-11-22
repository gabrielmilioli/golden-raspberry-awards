package com.milioli.goldenraspberryawards.resource;

import com.milioli.goldenraspberryawards.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProducerResourceTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ProducerService service;

    @Test
    public void getIntervalWins() throws Exception {

        final MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/api/producers/win-intervals")
                .accept(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("min").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("max").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("min[*].producer").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("min[*].interval").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("min[*].previousWin").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("min[*].followingWig").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("max[*].producer").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("max[*].interval").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("max[*].previousWin").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("max[*].followingWig").exists());
    }

}
