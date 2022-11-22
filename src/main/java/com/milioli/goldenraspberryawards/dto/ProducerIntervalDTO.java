package com.milioli.goldenraspberryawards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProducerIntervalDTO {

    private List<ProducerWinIntervalDTO> min;
    private List<ProducerWinIntervalDTO> max;

}
