package com.platzi.platziplayapi.domain.repository;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;

import java.util.List;

public interface MovieRepository {

    List<MovieDto> getAll();
    MovieDto getByID(long id);
    MovieDto save(MovieDto movieDto);
    MovieDto update(long id, MovieUpdateRequestDto movieUpdateRequestDto);
    MovieDto delete(long id);
}
