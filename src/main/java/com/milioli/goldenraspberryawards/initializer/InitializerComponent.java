package com.milioli.goldenraspberryawards.initializer;

import com.milioli.goldenraspberryawards.domain.Movie;
import com.milioli.goldenraspberryawards.domain.Producer;
import com.milioli.goldenraspberryawards.domain.Studio;
import com.milioli.goldenraspberryawards.service.MovieService;
import com.milioli.goldenraspberryawards.service.ProducerService;
import com.milioli.goldenraspberryawards.service.StudioService;
import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class InitializerComponent {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private StudioService studioService;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {

            final List<Movie> movies = new ArrayList<>();

            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            InputStream in = cl.getResourceAsStream("movielist.csv");
            Reader reader = new InputStreamReader(in);

            final CSVFormat csvFormat = CSVFormat.Builder.create()
                    .setHeader("year", "title", "studios", "producers", "winner")
                    .build();

            final Iterable<CSVRecord> records = csvFormat.parse(reader);

            for (CSVRecord record : records) {
                if (record.getRecordNumber() == 1) {
                    continue;
                }

                Long year = Long.valueOf(record.get("year").trim());
                String title = record.get("title").trim();
                String winner = record.get("winner").trim();

                String studios = record.get("studios");
                String producers = record.get("producers");

                final List<Studio> studiosFinal = studioService.createFromString(studios);

                final List<Producer> producersFinal = producerService.createFromString(producers);

                final Movie movie = Movie.builder()
                        .year(year)
                        .title(title)
                        .winner(parseYesNo(winner))
                        .studios(studiosFinal)
                        .producers(producersFinal)
                        .build();

                System.out.printf(movie.toString() + "\r\n");

                movies.add(movie);

            }

            movieService.saveAll(movies);

        };
    }

    private Boolean parseYesNo(String yesNo) {
        return "yes".equalsIgnoreCase(yesNo);
    }

}
