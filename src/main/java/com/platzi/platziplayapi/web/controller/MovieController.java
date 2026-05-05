package com.platzi.platziplayapi.web.controller;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;
import com.platzi.platziplayapi.domain.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getByID(@PathVariable long id) {
        MovieDto movieDto = this.movieService.getByID(id);
        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @PostMapping()
    public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.movieService.add(movieDto)
            );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> update(
            @PathVariable long id,
            @RequestBody MovieUpdateRequestDto movieToUpdateDto)
    {
        MovieDto movieDto = this.movieService.update(id, movieToUpdateDto);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> delete(@PathVariable long id) {
        MovieDto movieDto = this.movieService.delete(id);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }
}
