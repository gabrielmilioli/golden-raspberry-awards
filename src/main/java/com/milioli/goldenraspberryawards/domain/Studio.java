package com.milioli.goldenraspberryawards.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "studios")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_studios", sequenceName = "seq_studios", allocationSize = 1)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
