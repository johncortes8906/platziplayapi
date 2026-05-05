package com.platzi.platziplayapi.domain.dto;

import com.platzi.platziplayapi.domain.Genre;

import java.time.LocalDate;

public record MovieDto(
        Long id,
        String title,
        Integer length,
        Genre genre,
        LocalDate releaseDate,
        Double rating
) {


}
