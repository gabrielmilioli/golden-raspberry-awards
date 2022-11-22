package com.milioli.goldenraspberryawards.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "seq_movies", sequenceName = "seq_movies", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "year_movie", length = 4, nullable = false)
    private Long year;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToMany
    @JoinTable(name = "movies_studios",
            joinColumns = {
                    @JoinColumn(name = "id_movie", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_studio", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Studio> studios;

    @ManyToMany
    @JoinTable(name = "movies_producers",
            joinColumns = {
                    @JoinColumn(name = "id_movie", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "id_producer", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    private List<Producer> producers;

    @Column(name = "winner")
    private Boolean winner;

}
