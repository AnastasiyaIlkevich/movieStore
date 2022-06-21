package com.movieStore.controller;

import com.movieStore.dto.DTO;
import com.movieStore.dto.Genres;
import com.movieStore.service.AbstractService;
import com.movieStore.service.impl.TmdbUriBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Controller for filling and updating the data
 * of the table "genres" of the database with TMDB.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@RestController
@RequestMapping("/search")
public class TmdbSearchController {

    private final TmdbUriBuildService uriBuildService;
    private final AbstractService abstractService;


    @Autowired
    public TmdbSearchController(TmdbUriBuildService uriBuildService, @Qualifier("GenreService") AbstractService abstractService) {
        this.uriBuildService = uriBuildService;
        this.abstractService = abstractService;
    }

    WebClient webClient = WebClient.create();

    @GetMapping("/genres")
    public Flux<DTO> getAllGenreTmdb() throws URISyntaxException {
        Flux<DTO> genreflux = webClient
                .get()
                .uri(uriBuildService.createGenreSearchUrlBuilder())
                .retrieve()
                .bodyToFlux(DTO.class);
        List<DTO> collectGenres = genreflux.toStream().collect(Collectors.toList());// перевела в коллекцию
        DTO firstGenres = collectGenres.iterator().next();// достала из массива
        for (Genres genres : firstGenres.getGenres()) { // перебор массива
            abstractService.save(genres.toGenre()); // каждый сохранить в базе
        }
        return genreflux;
    }

//    @GetMapping("/movies/{title}")
//    public Flux<MovieDtoUpdate> getAllMoviesWebClient(@PathVariable("title") String title) throws URISyntaxException {
//
//        return webClient
//                .get()
//                .uri(uriBuildService.createMoviesSearchByTitleUrlBuilder(title))
//                .retrieve()
//                .bodyToFlux(MovieDtoUpdate.class);
//    }
}