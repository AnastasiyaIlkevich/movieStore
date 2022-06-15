package com.movieStore.controller;

import com.movieStore.dto.GenreDtoUpdate;
import com.movieStore.dto.MovieDtoUpdate;
import com.movieStore.service.impl.TmdbUriBuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/search")
public class TmdbSearchController {

    private final TmdbUriBuildService uriBuildService;

    @Autowired
    public TmdbSearchController(TmdbUriBuildService uriBuildService) {
        this.uriBuildService = uriBuildService;
    }

    WebClient webClient = WebClient.create();

    @GetMapping("/genres")
    public Flux<GenreDtoUpdate> getAllGenreTmdb() throws URISyntaxException {
        return webClient
                .get()
                .uri(uriBuildService.createGenreSearchUrlBuilder())
                .retrieve()
                .bodyToFlux(GenreDtoUpdate.class);
    }

    @GetMapping("/movies/{title}")
    public Flux<MovieDtoUpdate> getAllMoviesWebClient(@PathVariable("title") String title) throws URISyntaxException {

        return webClient
                .get()
                .uri(uriBuildService.createMoviesSearchByTitleUrlBuilder(title))
                .retrieve()
                .bodyToFlux(MovieDtoUpdate.class);
    }
}
