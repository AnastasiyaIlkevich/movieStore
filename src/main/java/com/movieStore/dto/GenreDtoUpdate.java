package com.movieStore.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.movieStore.model.Genre;
import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of a data transfer object designed
 * to convert json and further save it to the database.
 *
 * @author Ilkevich Anastasiya
 * @version 1.0
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class GenreDtoUpdate {

    private Long id;
    private String name;
    @JsonProperty("external_id")
    private Long externalId;

    public Genre toGenre() {
        Genre genre = new Genre();
        genre.setId(id);
        genre.setExternalId(externalId);
        genre.setName(name);
        return genre;
    }

    public GenreDtoUpdate fromGenre(Genre genre) {
        GenreDtoUpdate genreDto = new GenreDtoUpdate();
        genreDto.setId(genre.getId());
        genreDto.setExternalId(genre.getExternalId());
        genreDto.setName(genre.getName());
        return genreDto;
    }
}
