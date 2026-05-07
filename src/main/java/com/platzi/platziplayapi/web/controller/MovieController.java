package com.platzi.platziplayapi.web.controller;

import com.platzi.platziplayapi.domain.dto.MovieDto;
import com.platzi.platziplayapi.domain.dto.MovieUpdateRequestDto;
import com.platzi.platziplayapi.domain.dto.SuggestRequestDto;
import com.platzi.platziplayapi.domain.services.MovieService;
import com.platzi.platziplayapi.domain.services.PlatziPlayAiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/movies")
@Tag(name = "Movies", description = "Operations about movies.")
public class MovieController {

    private final MovieService movieService;
    private final PlatziPlayAiService platziPlayAiService;
    private  final String platform;

    public MovieController(
            MovieService movieService,
            PlatziPlayAiService platziPlayAiService,
            @Value("${spring.application.name}") String platform
    ) {
        this.movieService = movieService;
        this.platziPlayAiService = platziPlayAiService;
        this.platform = platform;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getMovies() {
        return ResponseEntity.ok(this.movieService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get a movie by its ID value",
            description = "Return a movie that has the ID value on the URL as a parameter.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "When the movie is found"),
                    @ApiResponse(responseCode = "404", description = "Movie could not be found.", content = @Content)
            }
    )
    public ResponseEntity<MovieDto> getByID(@Parameter(description = "ID of the movie to search") @PathVariable long id) {
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
            @Valid @RequestBody MovieUpdateRequestDto movieToUpdateDto)
    {
        MovieDto movieDto = this.movieService.update(id, movieToUpdateDto);

        if (movieDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movieDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        this.movieService.delete(id);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/suggests")
    public  ResponseEntity<String> getMoviesSuggestion(@RequestBody SuggestRequestDto suggestRequestDto) {
        return ResponseEntity.ok(
                this.platziPlayAiService.generateMoviesSuggestion(platform,
                        suggestRequestDto.moviesPreferences())
        );
    }
}
