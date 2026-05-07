package com.platzi.platziplayapi.persistence.crud;

import com.platzi.platziplayapi.persistence.entity.MovieEntity;
import org.springframework.data.repository.CrudRepository;

public interface CrudMovieEntity extends CrudRepository<MovieEntity, Long> {

    MovieEntity findFirstByTitle(String title);

}
