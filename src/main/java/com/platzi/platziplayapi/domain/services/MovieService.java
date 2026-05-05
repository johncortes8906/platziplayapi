package com.platzi.platziplayapi.domain.services;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;
import com.platzi.platziplayapi.domain.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDto> getAll() {
        return this.movieRepository.getAll();
    }

    public MovieDto getByID(long id) {
        return this.movieRepository.getByID(id);
    }

    public MovieDto add(MovieDto movieDto) {
        return this.movieRepository.save(movieDto);
    }

    public MovieDto update(long id, MovieUpdateRequestDto movieUpdateRequestDto) {
        return this.movieRepository.update(id, movieUpdateRequestDto);
    }

    public MovieDto delete(long id) {
        return this.movieRepository.delete(id);
    }
}
