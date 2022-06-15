package com.movieStore.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

@Slf4j
@Service
public class TmdbUriBuildService {

    @Value("${tmdb.api.url}")
    private String tmdbApiUrl;
    @Value("${tmdb.apikey}")
    private String tmdbApiKey;
    @Value("${tmdb.api.path.get.genres}")
    private String tmdbGenres;
    @Value("${tmdb.api.path.search.titele}")
    private String tmdbMovies;
    @Value("${tmdb.language}")
    private String tmdbLanguage;

    private final String API_KEY = "api_key";
    private final String LANGUAGE = "language";
    private final String QUERY = "query";

    public String createGenreSearchUrlBuilder() throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(tmdbApiUrl + tmdbGenres);
        uriBuilder.addParameter(API_KEY, tmdbApiKey);
        String uriGenres = uriBuilder.build().toString();
        log.info("Create new URI to search for genres " + uriGenres);
        return uriGenres;
    }

    public String createMoviesSearchByTitleUrlBuilder(String title) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(tmdbApiUrl + tmdbMovies);
        uriBuilder.addParameter(API_KEY, tmdbApiKey);
        uriBuilder.addParameter(LANGUAGE, tmdbLanguage);
        uriBuilder.addParameter(QUERY, title);
        String uriMovies = uriBuilder.build().toString();
        log.info("Create new URI to search for the movies " + uriMovies);
        return uriMovies;
    }
}
