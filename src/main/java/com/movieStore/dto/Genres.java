package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movieStore.model.Genre;
import lombok.Data;


    /**
     * Implementation of a data transfer object designed
     * to convert json and further save it to the database.
     *
     * @author Ilkevich Anastasiya
     * @version 1.0
     */

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    public class Genres {
        @JsonProperty("id")
        private Long id;
        @JsonProperty("name")
        private String name;

        public Genre toGenre() {
            Genre genre = new Genre();
            genre.setExternalId(id);
            genre.setName(name);
            return genre;
        }

        public com.movieStore.dto.GenreDtoUpdate fromGenre(Genre genre) {
            com.movieStore.dto.GenreDtoUpdate genreDto = new com.movieStore.dto.GenreDtoUpdate();
            genreDto.setId(genre.getExternalId());
            genreDto.setName(genre.getName());
            return genreDto;
        }
}
