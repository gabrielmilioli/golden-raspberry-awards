package com.milioli.goldenraspberryawards.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProducerWinIntervalDTO {

    private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWig;

}
