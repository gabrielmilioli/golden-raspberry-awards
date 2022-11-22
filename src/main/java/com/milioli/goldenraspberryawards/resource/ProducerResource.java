package com.milioli.goldenraspberryawards.resource;

import com.milioli.goldenraspberryawards.dto.ProducerIntervalDTO;
import com.milioli.goldenraspberryawards.service.ProducerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producers")
@AllArgsConstructor
public class ProducerResource {

    @Autowired
    private ProducerService service;

    @GetMapping("/win-intervals")
    private ResponseEntity<ProducerIntervalDTO> getIntervalWins() {
        return ResponseEntity.ok(service.getIntervalWins());
    }

}
