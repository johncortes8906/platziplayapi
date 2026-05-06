package com.platzi.platziplayapi.domain.services;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;
import com.platzi.platziplayapi.domain.repository.MovieRepository;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Tool("search all the existent movies of this platform.")
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

    public void delete(long id) {
        this.movieRepository.delete(id);
    }
}
