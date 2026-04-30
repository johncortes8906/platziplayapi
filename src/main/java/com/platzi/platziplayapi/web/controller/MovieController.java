package com.platzi.platziplayapi.web.controller;

import com.platzi.platziplayapi.persistence.crud.CrudMovieEntity;
import com.platzi.platziplayapi.persistence.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    private final CrudMovieEntity crudMovieEntity;

    public MovieController(CrudMovieEntity crudMovieEntity) {
        this.crudMovieEntity = crudMovieEntity;
    }

    @GetMapping("/movies")
    public List<MovieEntity> getMovies() {
        return (List<MovieEntity>)  this.crudMovieEntity.findAll();
    }
}
